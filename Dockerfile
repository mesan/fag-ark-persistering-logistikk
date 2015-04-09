##########################################################
# Dockerfile which builds a base image with oracle-java8.
##########################################################
FROM dockerfile/java:oracle-java8

ADD . /home

EXPOSE 8080

WORKDIR /home/src/main/java

ADD target/persistering-logistikk-0.0.1-SNAPSHOT.jar /home/src/main/java/persistering-logistikk.jar

CMD java -jar persistering-logistikk.jar