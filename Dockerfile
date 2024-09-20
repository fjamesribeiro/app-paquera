# Usar a imagem do OpenJDK
FROM openjdk:17-jdk-slim

# Criar um diretório para a aplicação
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o contêiner
COPY target/api-0.0.1-SNAPSHOT.jar app.jar

# Definir as variáveis de ambiente para o PostgreSQL e logging
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/dbpaquera
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=j@mEm1c
ENV SPRING_LOGGING_FILE=/app/logs/application.log

# Criar o diretório de logs
RUN mkdir -p /app/logs

# Expor a porta na qual a aplicação irá rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
