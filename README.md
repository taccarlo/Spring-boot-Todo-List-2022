# Spring Boot Course 2022

## Building a Simple Application with Spring Boot

### Controller-Service-Repository Architecture

* Controller - Contains application logic, mapping the user request to particular functions and passing the user input to service layer to apply the business logic.
* Service - Layer between the controller and repository which performs the business logic and validation logic.
* Repository - The layer which interact with the database CRUD operations via the DAOs (data access objects).
* Model - Is the simple classes which is acting as the DTO(Interact with application level data transfer) or DAO(Interaction with database operations).
