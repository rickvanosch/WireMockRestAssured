FROM java:8
FROM maven:3.2-jdk-8-onbuild
MAINTAINER loek

ADD . ./
RUN mvn install
CMD ["java", "-cp", "target/wsrs-1.0.jar", "Main"]