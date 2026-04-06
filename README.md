# 💹 Interest Rate Change Impact Simulator

> A production-ready **Spring Boot REST API** that empowers investors and financial planners to quantify the real monetary impact of interest rate changes on fixed-income investments — instantly.

---

## 🧑‍💻 About the Project

Interest rate shifts can silently erode or grow your investment returns. This simulator takes the guesswork out of it.

By providing a principal amount, investment duration, and two interest rate scenarios (current vs. proposed), the API calculates maturity values for both scenarios using the **compound interest formula**, computes the financial difference, and delivers a clear, descriptive impact message.

**Formula Used:**

$$A = P \left(1 + \frac{r}{100}\right)^t$$

---

## ✨ Key Features

| Feature | Description |
|---|---|
| 🔢 **Precise Calculation** | Compound interest formula with full floating-point precision |
| 📊 **Impact Analysis** | Automatically flags whether a rate change is a gain, loss, or neutral |
| 🏗️ **Clean Architecture** | Layered (Controller → Service → Repository) for maintainability |
| ✅ **Input Validation** | Handles edge cases like negative values, zero principal, invalid formats |
| 🗄️ **Persistent Storage** | Every calculation is saved to MySQL via Spring Data JPA |
| 📦 **JSON API** | Structured response bodies — ready for any frontend or fintech integration |

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.2.2 |
| Database | MySQL 8.0+ |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Apache Maven |
| API Style | RESTful (JSON) |

---

## 🏗️ Architecture Overview

The project follows a clean **Layered Architecture** for separation of concerns:

```
          HTTP Request
               │
               ▼
┌─────────────────────────────┐
│     Controller Layer        │  ← Handles HTTP, input validation, response mapping
│  InterestImpactController   │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│      Service Layer          │  ← Core business logic (compound interest, comparison)
│   InterestImpactService     │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│    Repository Layer         │  ← Spring Data JPA, persists results to MySQL
│ InterestCalculationRepo     │
└──────────────┬──────────────┘
               │
               ▼
          [ MySQL DB ]
```

---

## 📂 Project Structure

```
interest-rate-simulator/
├── pom.xml
└── src/main/java/com/interestratesimulator/
    ├── InterestRateSimulatorApplication.java   # Entry point
    ├── controller/
    │   └── InterestImpactController.java       # REST endpoints
    ├── entity/
    │   └── InterestCalculation.java            # JPA Entity (DB table)
    ├── model/
    │   ├── InterestRequest.java                # Request DTO
    │   └── InterestResponse.java               # Response DTO
    ├── repository/
    │   └── InterestCalculationRepository.java  # Data access layer
    └── service/
        └── InterestImpactService.java          # Business logic
```

---

## ⚙️ Getting Started

### Prerequisites

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

### 1. Clone the Repository

```bash
git clone https://github.com/ShreeKumbhar/Interest-Rate-Change-Impact-Simulator.git
cd Interest-Rate-Change-Impact-Simulator
```

### 2. Configure the Database

```sql
CREATE DATABASE interestdb;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/interestdb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

Server starts at: `http://localhost:8080`

---

## 📖 API Reference

### `POST /api/interest-impact/calculate`

Calculates and compares investment maturity under two different interest rate scenarios.

#### Request Body

```json
{
  "principal": 500000,
  "currentRate": 7,
  "newRate": 6,
  "years": 3
}
```

| Field | Type | Constraints | Description |
|---|---|---|---|
| `principal` | double | > 0 | Initial investment amount |
| `currentRate` | double | ≥ 0 | Current annual interest rate (%) |
| `newRate` | double | ≥ 0 | Proposed new interest rate (%) |
| `years` | int | > 0 | Investment duration in years |

#### Success Response — `200 OK`

```json
{
  "oldMaturityAmount": 612522.50,
  "newMaturityAmount": 595508.00,
  "difference": -17014.50,
  "message": "Interest rate decrease results in lower returns."
}
```

| Field | Type | Description |
|---|---|---|
| `oldMaturityAmount` | double | Maturity value at current rate |
| `newMaturityAmount` | double | Maturity value at new rate |
| `difference` | double | Monetary difference (new − old) |
| `message` | String | Plain-language impact summary |

#### Error Response — `400 Bad Request`

```json
{
  "error": "Invalid input parameters."
}
```

---

## 🧪 Testing the API

**Using cURL:**

```bash
curl -X POST http://localhost:8080/api/interest-impact/calculate \
  -H "Content-Type: application/json" \
  -d '{
    "principal": 10000,
    "currentRate": 5,
    "newRate": 5.5,
    "years": 5
  }'
```

**Using Postman:**
1. Method: `POST`
2. URL: `http://localhost:8080/api/interest-impact/calculate`
3. Body → raw → JSON → paste request body
4. Hit **Send**

---

## 📌 Sample Scenarios

| Principal | Current Rate | New Rate | Duration | Difference | Impact |
|---|---|---|---|---|---|
| ₹5,00,000 | 7% | 6% | 3 years | −₹17,014.50 | 📉 Loss |
| ₹10,000 | 5% | 5.5% | 5 years | +₹283.75 | 📈 Gain |
| ₹1,00,000 | 8% | 8% | 10 years | ₹0.00 | ➡️ No Change |

---

## 🔮 Future Enhancements

- [ ] Support for **Simple Interest** mode toggle
- [ ] Monthly/quarterly **compounding frequency** options
- [ ] Bulk calculation endpoint (array of scenarios)
- [ ] Swagger / OpenAPI documentation integration
- [ ] Dockerized deployment with `docker-compose`
- [ ] Unit & integration test coverage (JUnit 5 + Mockito)

---

## 👩‍💻 Author

**Shree Kumbhar**

[![GitHub](https://img.shields.io/badge/GitHub-ShreeKumbhar-181717?style=flat&logo=github)](https://github.com/ShreeKumbhar)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

> *Built to demonstrate hands-on experience with Spring Boot, RESTful API design, JPA persistence, and financial domain logic.*
