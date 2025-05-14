# 🏦 Consulta de Créditos Constituídos

Este projeto permite a consulta de créditos constituídos por meio de uma **API RESTful** desenvolvida com **Spring Boot (Java 17)** e uma interface web em **Angular 18**.  
O sistema também publica eventos no **Apache Kafka** sempre que uma consulta é realizada, permitindo **auditoria** e **análise de logs**.

O projeto é totalmente **containerizado com Docker Compose**, incluindo:

- ✅ Backend Spring Boot  
- ✅ Frontend Angular  
- ✅ Banco de dados MariaDB  
- ✅ Apache Kafka + Zookeeper  
- ✅ Interface web para visualização dos tópicos do Kafka (`kafka-ui`)  
- ✅ Flyway para versionamento de banco de dados  

---

## 🧩 Funcionalidades

- 🔍 Busca de créditos por número da NFS-e ou número do crédito  
- 📊 Tabela responsiva no frontend Angular  
- 💾 Armazenamento com MariaDB  
- 📦 Containerização completa via Docker  
- 📢 Publicação de eventos no Kafka  
- 👁️ Visualização de tópicos Kafka via `kafka-ui`  
- 🔄 Migração de banco com Flyway  
- 🌐 Suporte a CORS entre frontend e backend  

---

## 🚀 Tecnologias Utilizadas

### Backend
- Spring Boot (Java 17)

### Frontend
- Angular 18 (standalone)

### Banco de Dados
- MariaDB

### Mensageria
- Apache Kafka

### Containerização
- Docker + Docker Compose

### Migração de Banco
- Flyway

### Serialização JSON
- Jackson (`jackson-datatype-jsr310`)

---

## 📥 Como Baixar o Projeto

```bash
git clone https://github.com/wmsisinfo/consulta-credito.git
cd consulta-credito
```

---

## ⚙️ Estrutura do Projeto

```
consulta-credito/
├── backend/
├── frontend/
├── docker-compose.yml
└── README.md
```

---
## 🐳 Como Executar com Docker Compose

Na raiz do projeto, execute:

```bash
docker compose up --build
```

Este comando irá:

- Iniciar o MariaDB  
- Rodar as migrações Flyway  
- Subir a API Spring Boot em `http://localhost:8080`  
- Servir o frontend Angular em `http://localhost`  
- Disponibilizar o Kafka UI em `http://localhost:8081`  

> ⚠️ A primeira execução pode demorar mais tempo, pois todas as imagens serão baixadas.

---

##  🖥️ Como Testar o Frontend
Acesse no navegador:

http://localhost

Digite o número da NFS-e ou do Crédito
Clique em Buscar
Os resultados aparecerão em uma tabela organizada

## 🔍 Como Visualizar Eventos no Kafka

Acesse:
http://localhost:8081

No painel do Kafka UI:
No menu lateral esquerdo, clique em Topics
Selecione o tópico chamado consultas-realizadas
Na aba Messages , você verá os eventos gerados após cada consulta
Cada evento conterá informações como:

Tipo da consulta (NFS-e ou Crédito)
Valor consultado
Data e hora da consulta
Quantidade de registros encontrados
Resultados em formato JSON

---

## 🧪 Requisitos Mínimos

- ✅ Docker Engine >= **20.x**  
- ✅ Docker Compose v2+  
- ✅ Node.js >= **v18** + npm (para build local do frontend)  
- ✅ Java >= **17** (para rodar o backend localmente)

---
