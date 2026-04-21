# Restaurant Delivery System (Java + MySQL)

A console-based food delivery system developed in Java for an Object-Oriented Programming (OOP) course. The system simulates a simplified version of a food delivery platform, allowing customers to place orders from restaurants and enabling restaurants to manage products, orders, and deliveries.

---

## Project Overview

This project models a real-world delivery system with the following main actors:

* **Customers**: Can register, manage their account, browse restaurants, and place orders.
* **Restaurants**: Can manage products, view and update orders, and manage their business data.
* **Delivery Personnel**: Responsible for delivering orders and updating delivery status.

The system is implemented as a **Java console application** connected to a **MySQL database**.

---

## Technologies Used

* Java (JDK 8+)
* MySQL / PostgreSQL (relational database)
* JDBC (database connection)
* Object-Oriented Programming (OOP)

---

## Architecture

The project follows a layered architecture:

```
application/   → Console menus and program entry point
entities/      → Domain models (Customer, Product, Order, etc.)
database/      → Database connection (JDBC)
```

---

## Main Entities

* Cliente (Customer)
* Restaurante (Restaurant)
* Produto (Product)
* Pedido (Order)
* ItemPedido (Order Items)
* Entregador (Delivery Person)
* Endereço (Address hierarchy)

---

## Features

### Customer

* Create account
* Edit personal information
* Add delivery address
* Place orders from a single restaurant
* View order history and status

### Restaurant

* Manage profile
* Add and manage products
* View active orders
* Update order status
* Manage delivery personnel

### Delivery

* View assigned deliveries
* Update delivery status

---

## OOP Concepts Applied

* Encapsulation
* Inheritance (User → Customer / DeliveryPerson, Address hierarchy)
* Composition (Order contains OrderItems)
* Abstraction (layered structure with services/DAOs)

---

## Database

The system is connected to a relational database with tables including:

* CLIENTE
* RESTAURANTE
* PRODUTO
* PEDIDO
* ITEM_PEDIDO
* ENDERECO_CLIENTE
* ENDERECO_RESTAURANTE
* ENTREGADOR

Database connection is handled via JDBC in `database/DatabaseConnection.java`.

---

## Notes

* This project is a **learning-focused academic system**.
* Password encryption is not implemented.
* Some features may be simplified for educational purposes.

---

## Authors

Developed as part of an OOP university course project.
Team collaboration project.

---

## Future Improvements

* Add authentication system with encryption
* Improve UI (GUI or web version)
* Add product categories
* Improve order tracking system
* Better exception handling
