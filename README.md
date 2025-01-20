# FIAP-Tech-Challenge-I

Package adapter - centraliza tudo que é externa a aplicação. Ex.: acesso a db, apis externas ..
Package core - centraliza regras de negócio
Package infra - 



## Sumário 
MIRO - https://miro.com/app/board/uXjVLXZUyY0=/

## Introdução 
## Features
## Requisitos
## Local
## Docker
- Instalar OpenJDK 17
sudo apt install openjdk-17-jre-headless  # version 17.0.12+7-1ubuntu2~24.04
- Instalar
sudo apt install maven
- Buildando a imagem

docker build -t apptest .

docker-compose build  

docker-compose up -d

## Kubernetes
- Startar pod com comando
  
kubectl run tech-challenge-pod --image=larissay/tech-challenge-i --restart=Never --port=8080

## Teste
