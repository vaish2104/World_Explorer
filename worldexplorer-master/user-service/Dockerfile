FROM java:8-jre
ADD ./target/user-0.0.1-SNAPSHOT.jar /usr/src/user-0.0.1-SNAPSHOT.jar
EXPOSE 8001
WORKDIR usr/src
ENTRYPOINT ["java","-jar","user-0.0.1-SNAPSHOT.jar"]