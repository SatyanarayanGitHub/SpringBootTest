From openjdk:8-jdk-alpine
ADD target/SpringBootTest-0.0.1-SNAPSHOT.jar SpringBootTest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -jar /SpringBootTest-0.0.1-SNAPSHOT.jar"]