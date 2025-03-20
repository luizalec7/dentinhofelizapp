# Utiliza a imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR para dentro do container
COPY target/dentinhofelizapp-0.0.1-SNAPSHOT.war app.war

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.war"]