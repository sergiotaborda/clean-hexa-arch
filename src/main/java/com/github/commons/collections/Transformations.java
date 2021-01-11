package com.github.commons.collections;

import java.util.Arrays;

import com.github.commons.sequences.Sequence;

public class Transformations {

	
	public static Sequence<String> split(String text, String separator){
		if(!text.contains(separator)) {
			return Sequence.of(text);
		}
		return Sequence.of(Arrays.asList(text.split(separator)));
	}
	

}
