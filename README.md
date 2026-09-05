# Desafio Técnico

API REST para gerenciamento de tarefas, desenvolvida para o desafio técnico.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Arquitetura

Controller -> Service -> Repository -> H2

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | /tarefas | Cadastrar tarefa |
| GET | /tarefas | Listar tarefas |
| GET | /tarefas/{id} | Buscar por ID |
| PUT | /tarefas/{id} | Atualizar |
| DELETE | /tarefas/{id} | Remover |

## Executar

```bash
mvn spring-boot:run
```

API:
http://localhost:8080/tarefas

## H2 Console

http://localhost:8080/h2-console

JDBC URL:
jdbc:h2:mem:tarefasdb

Usuário:
sa

Senha:
vazia
