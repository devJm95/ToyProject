FROM amazoncorretto:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} toy.jar
ENTRYPOINT ["java","-jar","/toy.jar"]