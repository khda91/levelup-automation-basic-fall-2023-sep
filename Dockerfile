FROM markhobson/maven-chrome:jdk-11

ADD . /usr/src/mytests/
WORKDIR /usr/src/mytests

COPY ./src  /usr/src/mytests
COPY ./pom.xml  /usr/src/mytests

RUN mvn install -Dmaven.test.skip=true

ENTRYPOINT mvn clean test -P cicd-allure-all-tests
