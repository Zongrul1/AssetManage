FROM java:8
VOLUME /tmp
COPY /target/assetManage-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /app
EXPOSE 10088
ENTRYPOINT ["java", "-jar", "app.jar"]
