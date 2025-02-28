
FROM openjdk:8-jdk-alpine AS build
RUN apk add --no-cache maven
# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and build the application
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

FROM tomcat:8.5-jdk8-openjdk

# Copy the built application from the build stage
COPY --from=build /app/target/RentSathi.war /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080

# Run Tomcat
ENTRYPOINT ["catalina.sh", "run"]