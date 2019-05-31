FROM openjdk:8-jre-alpine

ENV APPLICATION_USER simple
ENV JAR simple_thrift.jar

RUN adduser -D -g '' $APPLICATION_USER
RUN mkdir /app
RUN chown -R $APPLICATION_USER /app

USER $APPLICATION_USER

COPY ./$JAR /app/$JAR
WORKDIR /app

CMD ["java", "-jar", "simple_thrift.jar"]


