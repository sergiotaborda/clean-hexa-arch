FROM openjdk:15
ADD target/reference-node.jar reference-node.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "reference-node.jar"]