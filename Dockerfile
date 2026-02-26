FROM maven
LABEL authors="topi"

WORKDIR /app

COPY pom.xml .
COPY . /app
RUN mvn clean package
CMD ["java","-jar","target/TCMain.jar"]

