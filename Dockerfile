FROM azul/zulu-openjdk-alpine:11
COPY "build/libs/ivapedb-0.0.1-SNAPSHOT.jar" "/app.jar"

EXPOSE 9999
CMD [ "-jar", "/app.jar" ]
ENTRYPOINT [ "java" ]