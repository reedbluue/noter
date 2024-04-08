#
# BUILD STAGE
#
FROM maven:3.9.6-amazoncorretto-21 AS build
COPY src /usr/src/noter-backend/src
COPY pom.xml /usr/src/noter-backend
RUN mvn -f /usr/src/noter-backend/pom.xml clean package -DskipTests

#
# PACKAGE STAGE
#
FROM amazoncorretto:21
COPY --from=build /usr/src/noter-backend/target/noter-backend-0.0.1.jar /usr/app/noter-backend-0.0.1.jar
EXPOSE 8081
CMD ["java","-jar","/usr/app/noter-backend-0.0.1.jar"]