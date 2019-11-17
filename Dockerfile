FROM openjdk:latest
ADD target/app_englingo.jar app_englingo.jar
EXPOSE 8800
ENTRYPOINT ["java", "-jar", "app_englingo.jar"]
