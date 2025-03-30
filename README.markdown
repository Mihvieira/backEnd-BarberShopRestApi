 ``` mermaid

classDiagram
    class BarberShop {
            +Long id
            +String openingHours
            +String workingDays
            +Set<Service> services
            +List<Client> clients
            +List<Appointment> calendar
    }

    class WorkingDays {
        Days workingDay;
        LocalDateTime openingHour;
        LocalDateTime closingHour;
        LocalDateTime startBreakTime;
        LocalDateTime endBreakTime;
    }

    class Service {
        +Long id
        +String name
        +Duration duration
        +double price
    }
    class Appointment {
        +Long id
        +Client client
        +Service service
        +Date date
        +Time time
        +String status
    }
    class Client {
        +Long id
        +String name
        +String phone
        +String email
        +Agendamento appointment
        +List<Payment> payments
    }
    class Payment {
        +Long id
        +String paymentMethod
        +Date date
        +double amount
    }
    BarberShop --> Service : "1..*"
    Appointment --> Service : "1"
    BarberShop --> Appointment : "1..*"
    Client --> Appointment : "1"
    BarberShop --> Client : "1..*"
    Client --> Payment : "1..*"
    
    ```
