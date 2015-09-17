#Dockerfile for creating environment for java CI process execution
FROM ubuntu
MAINTAINER Gaurang Rathod <gaurang@example.com>


#installing java8
RUN mkdir -p /opt/java/jdk1.8.0_45
COPY jdk1.8.0_45 /opt/java/jdk1.8.0_45/
RUN chmod -R 777 /opt/java/jdk1.8.0_45/

#installing maven 3.0.4
RUN mkdir -p /opt/apache-maven-3.0.4
COPY apache-maven-3.0.4 /opt/apache-maven-3.0.4/
RUN chmod -R 777 /opt/apache-maven-3.0.4/

#copying repository
COPY repository /root/.m2/repository/

#setting env variables
ENV JAVA_HOME /opt/java/jdk1.8.0_45
ENV M2_HOME /opt/apache-maven-3.0.4
ENV MAVEN_HOME /opt/apache-maven-3.0.4
ENV PATH $PATH:$JAVA_HOME/bin:$M2_HOME/bin

RUN echo $PATH
RUN echo $JAVA_HOME

#Copying source code
RUN mkdir -p /opt/MockitoPOC/
#COPY MockitoPOC /opt/MockitoPOC/
RUN mkdir -p /opt/MockitoPOC/src
RUN mkdir -p /opt/MockitoPOC/target
COPY src /opt/MockitoPOC/src/
COPY target /opt/MockitoPOC/target/
COPY pom.xml /opt/MockitoPOC/pom.xml
COPY Dockerfile /opt/MockitoPOC/Dockerfile


#ENTRYPOINT sh /usr/local/tomcat/apache-tomcat-7.0.61/bin/startup.sh; /bin/bash


