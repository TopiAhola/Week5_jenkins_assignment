FROM maven:latest
LABEL authors="topi"

WORKDIR /app

COPY pom.xml pom.xml

COPY . /app

RUN mvn clean package



ENTRYPOINT ["top", "-b"]


CMD ["java","-jar","target/"]

