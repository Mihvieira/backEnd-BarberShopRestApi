# BarberShop REST API

## Descrição do Projeto
A **BarberShop REST API** é uma aplicação desenvolvida em Java utilizando o framework Spring Boot. Ela fornece funcionalidades para gerenciar um sistema de barbearia, incluindo clientes, serviços, agendamentos, pagamentos e dias de funcionamento. A API segue os princípios RESTful e utiliza o banco de dados MySQL para persistência.

## Funcionalidades
- **Gerenciamento de Clientes**: Cadastro, atualização, exclusão e consulta de clientes.
- **Gerenciamento de Serviços**: Cadastro, atualização, exclusão e consulta de serviços oferecidos pela barbearia.
- **Agendamentos**: Criação, atualização, exclusão e consulta de agendamentos.
- **Pagamentos**: Registro e consulta de pagamentos realizados pelos clientes.
- **Dias de Funcionamento**: Configuração dos dias e horários de funcionamento da barbearia.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
  - Spring Data JPA
  - Spring Web
  - Spring Validation
- **MySQL**
- **Hibernate**
- **MapStruct** (para mapeamento de DTOs)
- **Lombok**
- **Flyway** (para migração de banco de dados)
- **H2 Database** (para testes)

## Estrutura do Projeto
O projeto segue a arquitetura em camadas:
- **Controller**: Responsável por expor os endpoints da API.
- **Service**: Contém a lógica de negócios.
- **Repository**: Gerencia a comunicação com o banco de dados.
- **Entity**: Representa as tabelas do banco de dados.
- **DTO**: Objetos de transferência de dados para comunicação entre camadas.

## Diagrama de Classes
Abaixo está o diagrama de classes representando as entidades do sistema:

```mermaid
classDiagram
    class BarberShop {
        +Long id
        +String name
        +String address
        +List<WorkingDays> workingDays
    }

    class WorkingDays {
        +Long id
        +Days workingDay
        +OffsetTime openingHour
        +OffsetTime closingHour
        +OffsetTime startBreakTime
        +OffsetTime endBreakTime
        +BarberShop barberShop
    }

    class BarberService {
        +Long id
        +String name
        +OffsetTime duration
        +BigDecimal price
        +String note
        +List<Schedule> schedules
    }

    class Schedule {
        +Long id
        +Client client
        +BarberService barberService
        +OffsetDateTime date
        +ScheduleStatus status
    }

    class Client {
        +Long id
        +String name
        +String phone
        +String email
        +List<Schedule> schedules
        +List<Payment> payments
    }

    class Payment {
        +Long id
        +PaymentMethods paymentMethod
        +OffsetDateTime date
        +BigDecimal amount
        +Client client
    }

    BarberShop --> WorkingDays : "1..*"
    BarberShop --> Client : "1..*"
    BarberShop --> BarberService : "1..*"
    WorkingDays --> BarberShop : "1"
    Schedule --> Client : "1"
    Schedule --> BarberService : "1"
    Client --> Payment : "1..*"
```

## Como Executar o Projeto
1. Clone o repositório:
```
git clone https://github.com/seu-usuario/barbershop-rest-api.git
```
2. Configure o banco de dados no arquivo application.yml ou .env.
3. Execute o projeto:
```
./mvnw spring-boot:run
```
4. Acesse a API em 
```
http://localhost:8080
```

## Endpoints Principais
Clientes
* GET /client: Lista todos os clientes.
* POST /client: Cadastra um novo cliente.
* PUT /client: Atualiza um cliente existente.
* DELETE /client/{id}: Remove um cliente.

Serviços
* GET /barber_service: Lista todos os serviços.
* POST /barber_service: Cadastra um novo serviço.
* PUT /barber_service: Atualiza um serviço existente.
* DELETE /barber_service/{id}: Remove um serviço.

Agendamentos
* GET /schedule: Lista todos os agendamentos.
* POST /schedule: Cria um novo agendamento.
* PUT /schedule: Atualiza um agendamento existente.
* DELETE /schedule/{id}: Remove um agendamento.

Pagamentos
* GET /payment: Lista todos os pagamentos.
* POST /payment: Registra um novo pagamento.
* PUT /payment: Atualiza um pagamento existente.
* DELETE /payment/{id}: Remove um pagamento.