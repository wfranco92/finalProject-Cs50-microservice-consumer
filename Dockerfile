FROM openjdk:11.0.12
EXPOSE 8080
ADD target/cs50-finalproject-consumer.jar cs50-finalproject-consumer.jar
ENTRYPOINT ["java", "-jar", "/cs50-finalproject-consumer.jar"]