package com.github.commons.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.github.commons.sequences.Sequence;


public class Reflection {
 
	public static <T> T newInstance(Class<T> type) {
		
			try {
				return type.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new ReflectionException(e);
			}
	}
	

	public static <S,P> PropertyMetadata obtainFromSelector(Class<S> beanType, Function<S, P> sourcePropertySelector) {
		var probe = new Probe();
		var probedSource = beanType.cast(Enhancer.create(beanType,probe));
		
		sourcePropertySelector.apply(probedSource);
		var name = parseName(probe.methodName);
		
		return new PropertyMetadata(name, beanType, parseType(probe.propertyType,beanType, name));
	}
	
	
	private static Class parseType(Class propertyType, Class type, String propertyName) {
		if (!Optional.class.isAssignableFrom(propertyType)) {
			return propertyType;
		}
		
		var setter = "set" + propertyName;
		
		return Sequence.of(type.getMethods()).filter(m -> m.getName().equals(setter)).findAny()
		.map(m -> m.getParameters()[0].getType())
		.orElseThrow(() -> new IllegalStateException(propertyName + " is not modifable"));
	}


	private static String parseName(String methodName) {
		if (methodName.startsWith("get")) {
			return methodName.substring(3);
		} else if (methodName.startsWith("is")) {
			return methodName.substring(2);
		} 
		throw new IllegalStateException("Cannot map a non property method");
	}


}

class Probe implements MethodInterceptor{

	public String methodName;
	public Class<?> propertyType;
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		this.methodName = method.getName();
		this.propertyType = method.getReturnType();
		
		return null;
	}
	
	
}