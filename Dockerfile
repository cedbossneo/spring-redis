FROM java:8
RUN mkdir /app
ADD build/libs/spring-redis-0.0.1-SNAPSHOT.jar /app/
ADD bootInDocker.sh /app/
WORKDIR /app
RUN chmod a+x bootInDocker.sh

EXPOSE 8080

CMD /app/bootInDo   cker.sh