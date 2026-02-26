FROM maven
LABEL authors="topi"

WORKDIR /app

COPY pom.xml .
COPY . /app
RUN mvn clean package
CMD ["java","-jar","target/Week5_jenkins_assignment-1.0-SNAPSHOT.jar"]

