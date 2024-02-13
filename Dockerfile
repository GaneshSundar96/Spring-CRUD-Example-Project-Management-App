FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY target/* /home/app/target/
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true
EXPOSE 8080 
ENTRYPOINT ["java","-jar","/home/app/target/project_tracker-0.0.1-SNAPSHOT.jar"]
