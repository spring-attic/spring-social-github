FROM openjdk:8-alpine

RUN apk add bash

# Create user
RUN adduser -D user
USER user
RUN mkdir /home/user/code
WORKDIR /home/user/code

COPY --chown=user . .
ARG MAVEN_USER
ARG MAVEN_PASSWORD
RUN ./gradlew build
CMD ./gradlew publish
