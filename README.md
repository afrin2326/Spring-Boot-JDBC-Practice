# Spring Boot JDBC Practice

A collection of **Spring Boot JDBC practice projects** demonstrating core database programming concepts using **Java, Spring Boot, JDBC, MySQL, and HikariCP**.

This repository contains hands-on implementations of CRUD operations, batch processing, parameterized queries, `NamedParameterJdbcTemplate`, `SqlParameterSource`, and database connection pooling.

---

## 📌 Repository Overview

The projects in this repository were developed as part of my **Spring Boot and JDBC learning journey**, with a focus on understanding how Java applications communicate with relational databases using Spring's JDBC support.

### Topics Covered

* Spring Boot JDBC
* JDBC CRUD Operations
* `JdbcTemplate`
* `NamedParameterJdbcTemplate`
* Positional Parameters
* Named Parameters
* `MapSqlParameterSource`
* `BeanPropertySqlParameterSource`
* Batch Updates
* Parameter Binding
* MySQL Database Connectivity
* Database Connection Pooling
* HikariCP
* Exception Handling
* SQL Queries with Spring Boot

---

## 🛠️ Technologies Used

| Technology       | Purpose                       |
| ---------------- | ----------------------------- |
| **Java**         | Programming Language          |
| **Spring Boot**  | Application Framework         |
| **Spring JDBC**  | Database Access               |
| **MySQL**        | Relational Database           |
| **Maven**        | Dependency Management & Build |
| **HikariCP**     | Database Connection Pooling   |
| **Git & GitHub** | Version Control               |

---

## 📂 Projects

### 1. BatchUpdatesInJdbcNamedParameter

Demonstrates performing **batch database operations using named parameters** with Spring JDBC.

**Key Concepts:**

* `NamedParameterJdbcTemplate`
* Named SQL parameters
* Batch insert/update operations
* `SqlParameterSource`

---

### 2. BatchUpdatesInJdbcPositionalParameter

Demonstrates **batch operations using positional parameters**.

**Key Concepts:**

* `JdbcTemplate`
* Positional parameters (`?`)
* Batch updates
* Prepared statements

---

### 3. BatchUpdatesInSpringBootJdbc

A Spring Boot implementation of **JDBC batch processing**.

**Key Concepts:**

* Spring Boot JDBC
* `JdbcTemplate`
* Batch operations
* MySQL integration

---

### 4. NamedParameterJdbcUsingBeanPropertySqlParameter

Demonstrates using `BeanPropertySqlParameterSource` to bind Java object properties directly to named SQL parameters.

**Key Concepts:**

* `NamedParameterJdbcTemplate`
* `BeanPropertySqlParameterSource`
* Java Bean property mapping
* Named parameter binding

---

### 5. NamedParameterJdbcUsingMap

Demonstrates using a `Map` to provide values for named SQL parameters.

**Key Concepts:**

* `NamedParameterJdbcTemplate`
* Named parameters
* `Map<String, Object>`
* Parameter binding

---

### 6. NamedParameterJdbcUsingMapSqlParameterSource

Demonstrates using `MapSqlParameterSource` for handling named SQL parameters.

**Key Concepts:**

* `NamedParameterJdbcTemplate`
* `MapSqlParameterSource`
* Named parameter binding
* Parameter management

---

### 7. SpringBootJdbcProgram

A basic Spring Boot JDBC application demonstrating database connectivity and common JDBC operations.

**Key Concepts:**

* Spring Boot
* `JdbcTemplate`
* MySQL connectivity
* CRUD operations
* SQL queries
* Dependency injection

---

### 8. SpringBootConnectionPooling

Demonstrates **database connection pooling** using Spring Boot and HikariCP.

**Key Concepts:**

* HikariCP
* Connection pooling
* Database connection management
* Pool configuration
* Performance-oriented database access

---

## 🏗️ General Project Structure

Each project follows a typical Spring Boot application structure:

```text
ProjectName/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── ...
├── pom.xml
└── README.md (if applicable)
```

---

## ⚙️ Prerequisites

Before running the projects, make sure you have:

* **Java 21+**
* **Maven**
* **MySQL Server**
* **Git**
* An IDE such as:

  * Spring Tool Suite
  * Eclipse
  * IntelliJ IDEA
  * VS Code

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/afrin2326/Spring-Boot-JDBC-Practice.git
```

Navigate into the repository:

```bash
cd Spring-Boot-JDBC-Practice
```

---

### 2. Select a Project

For example:

```bash
cd SpringBootJdbcProgram
```

Each project is an independent Spring Boot application.

---

### 3. Configure MySQL

Create the required database in MySQL according to the SQL/table structure used by the selected project.

The database configuration is intentionally **not hard-coded with credentials** in this repository.

The applications use environment variables:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

This keeps database credentials outside the source code.

---

### 4. Set Environment Variables

#### Windows Command Prompt

```cmd
set DB_URL=jdbc:mysql://localhost:3306/your_database
set DB_USERNAME=your_username
set DB_PASSWORD=your_password
```

#### Windows PowerShell

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/your_database"
$env:DB_USERNAME="your_username"
$env:DB_PASSWORD="your_password"
```

#### Linux / macOS

```bash
export DB_URL="jdbc:mysql://localhost:3306/your_database"
export DB_USERNAME="your_username"
export DB_PASSWORD="your_password"
```

> **Note:** Replace the values with your own local MySQL configuration. Never commit actual database passwords or API keys to GitHub.

---

## ▶️ Running the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or build the project first:

```bash
mvn clean install
```

Then run the generated JAR:

```bash
java -jar target/<application-name>.jar
```

You can also run the main Spring Boot class directly from your IDE.

---

## 🔐 Security

Sensitive database credentials are intentionally excluded from this repository.

The projects use environment variables instead of storing credentials directly in `application.properties`.

### Never commit:

```text
DB passwords
API keys
Access tokens
Private keys
.env files containing secrets
Production credentials
```

The repository also uses `.gitignore` to prevent common IDE files, build artifacts, logs, and local environment files from being committed.

---

## 📚 Learning Objectives

Through these projects, I practiced and explored:

1. Connecting Spring Boot applications with MySQL.
2. Performing CRUD operations using JDBC.
3. Working with `JdbcTemplate`.
4. Using `NamedParameterJdbcTemplate`.
5. Understanding positional vs. named parameters.
6. Performing batch database operations.
7. Binding Java objects to SQL parameters.
8. Using `MapSqlParameterSource`.
9. Managing database connections efficiently.
10. Understanding HikariCP connection pooling.
11. Structuring Spring Boot applications using Maven.
12. Managing database configuration securely.

---

## 🔄 JDBC Parameter Binding

### Positional Parameters

Example:

```sql
SELECT * FROM employee WHERE id = ?
```

Values are supplied according to their position.

### Named Parameters

Example:

```sql
SELECT * FROM employee WHERE id = :id
```

Named parameters make SQL statements more readable and easier to maintain.

---

## ⚡ Connection Pooling

The `SpringBootConnectionPooling` project demonstrates database connection pooling with **HikariCP**.

Instead of creating a new database connection for every operation, a connection pool maintains reusable database connections.

This can help applications:

* Reduce connection creation overhead
* Improve database access efficiency
* Handle multiple database requests
* Manage database resources more effectively

---

## 📈 Repository Purpose

This repository serves as a **practical reference and learning portfolio** for Spring Boot JDBC and relational database programming.

The projects progress from basic JDBC operations to more advanced concepts such as:

```text
JDBC
  ↓
JdbcTemplate
  ↓
Parameterized Queries
  ↓
NamedParameterJdbcTemplate
  ↓
Batch Operations
  ↓
Parameter Source Abstraction
  ↓
Connection Pooling
```

---

## 👩‍💻 Author

**Mst Afrin Binte Amin**

Computer Science & Engineering
Machine Learning & Software Engineering Enthusiast

### Profiles

* GitHub: [afrin2326](https://github.com/afrin2326)
* LinkedIn: [Mst Afrin Binte Amin](https://www.linkedin.com/in/afrin-binte-amin-48a52b417/)

---

## ⭐ Acknowledgement

This repository was created for educational and practical learning purposes while studying **Java, Spring Boot, JDBC, and database application development**.

If you find this repository useful, feel free to ⭐ the repository.

---

## 📄 License

This project is intended primarily for educational and learning purposes.
