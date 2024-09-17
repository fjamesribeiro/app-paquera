#!/bin/bash

# Para parar e remover contêineres, redes e volumes do docker-compose
sudo docker-compose down

# Para limpar e construir o projeto com o Maven, pulando os testes
mvn clean package -DskipTests -e

# Para construir novamente os contêineres do Docker
sudo docker-compose build

# Para iniciar os contêineres
sudo docker-compose up
