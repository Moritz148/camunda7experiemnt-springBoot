FROM openjdk:23
LABEL authors="MoritzSchwarz"

COPY target/camunda7-worker*.jar /demoC7Application.jar

CMD ["java", "-jar", "/demoC7demoC7Application.jar"]