FROM openjdk:16
COPY target/final_project-0.0.1-SNAPSHOT.jar final_project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/final_project-0.0.1-SNAPSHOT.jar"]
