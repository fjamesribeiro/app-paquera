#!/bin/bash

# Redirecionar a saída para log.txt
{
	echo "parando e removendo contêineres, redes e volumes do docker-compose"
	sudo docker-compose down
	
    echo "Iniciando a limpeza e construção do projeto Maven..."
    mvn clean package -DskipTests -e

    echo "Construindo os contêineres do Docker..."
    sudo docker-compose build

    echo "Iniciando os contêineres..."
    sudo docker-compose up -d
} > log.txt 2>&1
