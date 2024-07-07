FROM openjdk:17-jdk-alpine

RUN addgroup dev 
RUN adduser -S -G dev teste
USER teste

WORKDIR /apiusuarios.empresas

COPY . .

EXPOSE 8001

CMD ["java" , "-jar" , "target/spring-boot-2-jpa-with-hibernate-and-h2-0.0.1-SNAPSHOT.jar"]

