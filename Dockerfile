FROM openjdk:21
EXPOSE 8080
ADD "backend/target/quizzie.jar" app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]