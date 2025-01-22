# FIAP-Tech-Challenge-I

## Sistema de Controle de Pedidos para Lanchonete - Tech Challenge


### Desenho de Arquitetura de Infraestrutura

![Diagrama de Infra](/C4/imgs/Arquitetura-Infra.png)

---

```

com.fiap.TECH_Challenge
├── core
│   ├── domain              // Entidades, Value Objects, Regras de Negócio
│   ├── usecase/service     // Casos de Uso (Application Layer)
│   └── port
│       ├── in              // Interfaces Entrada
│       └── out             // Interfaces de Saída
├── adapter
│   ├── controler           // Gerencia requisições HTTP e direciona respostas
│   ├── converter           // Transforma dados em diferentes formatos.
│   ├── entity              // Representa tabelas ou objetos no banco.
│   ├── factory             // Criação controlada de objetos complexos simplificada.
│   ├── repository          // Abstração para acessar dados persistentes.
│   ├── request             // Representa dados enviados pelo cliente
│   └── response            // Envia dados ou status ao cliente.
├── infra                   // Beans e configurações.
└── resources               // Gerencia arquivos e configurações externas.

```

MIRO - https://miro.com/app/board/uXjVLXZUyY0=/

## Descrição do Problema
Expansão de uma lanchonete de bairro trouxe desafios de organização e eficiência no atendimento ao cliente. Sem um sistema de controle, há risco de erros nos pedidos, atrasos e insatisfação dos clientes. 

Para resolver esse problema, será desenvolvido um **Sistema de Autoatendimento de Fast Food** com:
- Totens para pedidos.
- Interface para montagem de combos.
- Sistema de acompanhamento de pedidos.
- Integração de pagamento via QRCode.
- Painel administrativo para gerenciamento de clientes, produtos e pedidos.

---


## Sumário 

## Introdução 

## Features

| Feature | Objetivo |
| ------ | ------ |
| Doc | Aumentar a compreensão, manutenção, colaboração e facilitar o uso do software por desenvolvedores e usuários |
| Implementacao JWT | Criar autenticação e autorização de usuários de forma segura, garantindo integridade, confidencialidade. Requisito mínimo para aplicações distribuídas e modernas |
| Pagamento | Implementação de consumo API Marcado Pago (andamento) |
| Padrao Response | Facilitar integração, padronizar comunicação, melhorar debugging e garantir consistência entre sistemas e consumidores da API |
| PostgreSQL| Implementar banco de dados PostgreSQL |


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

---

## Kubernetes
- Startar pod com comando
  
kubectl apply -f api-deployment.yaml  

kubectl apply -f api-service.yaml  

kubectl apply -f db-deployment.yaml  

kubectl apply -f db-service.yaml  


---

## Teste

---

## Objetivos do Sistema

1. **Garantir Eficiência e Organização:**
   - Reduzir erros e atrasos na preparação de pedidos.
2. **Melhorar a Experiência do Cliente:**
   - Oferecer autoatendimento ágil e acompanhamento em tempo real.
3. **Suporte ao Crescimento do Negócio:**
   - Permitir à lanchonete escalar com processos digitais otimizados.

---

## Tecnologias Utilizadas
- **Backend:** Java com Spring Boot.
- **Frontend:** Angular (ou framework similar).
- **Banco de Dados:** PostgreSQL.
- **Orquestração de Contêineres:** Kubernetes (AKS, EKS, ou GKE).
- **Contêinerização:** Docker.
- **Autenticação:** JWT.
- **Pagamento:** Integração com Mercado Pago (via QRCode).
- **Monitoramento:** Prometheus e Grafana.

---

## Funcionalidades
### Para Clientes

- **Pedido:**
  - Seleção de itens (Lanche, Acompanhamento, Bebida, Sobremesa).
  - Opção de identificação via CPF ou cadastro.
- **Pagamento:**
  - QRCode integrado ao Mercado Pago.
- **Acompanhamento:**
  - Status do pedido: Recebido, Em Preparação, Pronto, Finalizado.
- **Notificação:**
  - Alerta para retirada do pedido.

### Para Administradores

- Gerenciamento de clientes para campanhas promocionais.
- Gerenciamento de produtos e categorias.
- Acompanhamento de pedidos em andamento.

---

## Arquitetura do Sistema (Modelo C4)
### Nível 1 - Contexto

O sistema consiste em três principais usuários:
1. **Clientes:** Utilizam autoatendimento e acompanham o status do pedido.
2. **Administradores:** Gerenciam produtos, categorias e acompanham pedidos.
3. **Sistema de Pagamento:** Processa os pagamentos via Mercado Pago.

![Diagrama de Contexto](/C4/imgs/diagrama-TechChallengeContext.png)


### Nível 2 - Contêineres

O sistema é composto por vários serviços contidos em contêineres Docker e orquestrados pelo Kubernetes.

| Serviço          | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Backend**      | API RESTful para processamento de pedidos e lógica de negócios (Spring).|
| **Banco de Dados** | Armazena informações de produtos, pedidos e usuários (PostgreSQL).    |
| **Pagamento**    | Integração com Mercado Pago para pagamentos.                            |


![Diagrama de Contêineres](/C4/imgs/diagrama-TechChallengeContainer.png)


### Nível 3 - Componentes

**Backend:**
- **OrderService:** Processa pedidos e atualiza status.
- **PaymentService:** Realiza a integração com Mercado Pago.
- **UserService:** Gerencia dados de clientes e administradores.
- **ProductService:** Permite a administração de produtos e categorias.

![Diagrama de Componentes](/C4/imgs/diagrama-TechChallengeComponent.png)


### Nível 3 - Código

![Diagrama de Codigos](/C4/imgs/diagrama-TechChallengeCodigo.png)


---

## Infraestrutura

- **Orquestração:** Kubernetes (implementação específica pode variar: AKS, EKS ou GKE).
- **Monitoramento:** Prometheus (monitoramento) e Grafana (visualização de métricas).
- **Horizontal Pod Autoscaler (HPA):** Escalabilidade automática baseada em CPU e memória.
- **Ingress Controller:** Gerenciamento de tráfego de entrada.
- **ConfigMaps e Secrets:** Configuração de variáveis sensíveis como `JWT_SECRET` e credenciais de banco.

---

## Implantação
### Requisitos

1. **Docker e Kubernetes instalados.**
2. Configuração do cluster com suporte ao HPA.

---

### Passos

1. **Build dos contêineres Docker:**
   ```bash
   docker build -t tech-challenge-backend ./backend
