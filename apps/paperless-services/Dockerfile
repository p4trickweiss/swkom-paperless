#
# Build stage
#
FROM maven:3.9.4-amazoncorretto-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17-slim
RUN apt-get update && apt-get -y install tesseract-ocr && apt-get install tesseract-ocr-eng && apt-get install tesseract-ocr-deu
COPY --from=build /home/app/target/paperless-services-1.0.jar /usr/local/lib/paperless-services.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/paperless-services.jar"]
