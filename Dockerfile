FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/menu-service-0.0.1.jar menuService.jar
ENTRYPOINT ["java", "-jar", "menuService.jar"]
