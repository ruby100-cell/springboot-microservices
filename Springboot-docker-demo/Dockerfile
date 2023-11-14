FROM eclipse-temurin:17


LABEL mentainer="rubybtechbanasthali@gmail.com"

WORKDIR /app

COPY target/Springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]