# Interest Rate Impact Simulator

A robust Spring Boot REST API for financial analysis, specifically designed to simulate and calculate the impact of interest rate changes on fixed-income investments using the compound interest formula.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Key Features](#key-features)
- [Tech Stack](#tech-stack)
- [Project Architecture](#project-architecture)
- [Folder Structure](#folder-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Contact](#contact)

## 🚀 Project Overview

The **Interest Rate Impact Simulator** allows users to compare the maturity value of an investment under two different interest rate scenarios. By inputting a principal amount, duration, and two interest rates (current and new), the system calculates the maturity values for both scenarios, computes the difference, and provides a descriptive message indicating whether the change results in a gain, loss, or no impact.

This tool is essential for investors and financial planners to visualize the quantitative effect of rate fluctuations over time.

## ✨ Key Features

- **Precise Calculation**: Uses the standard Compound Interest formula $ A = P(1 + \frac{r}{100})^t $.
- **Impact Analysis**: Automatically determines if a rate change is beneficial or detrimental.
- **RESTful Architecture**: Clean, resource-oriented API design.
- **Input Validation**: Ensures robust handling of invalid data (e.g., negative principal or rates).
- **JSON Response**: Structured, easy-to-parse JSON output for frontend integration.

## 🛠 Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot 3.2.2
- **Database**: MySQL 8.0+
- **Persistence**: Spring Data JPA / Hibernate
- **Build Tool**: Maven
- **Dependencies**: Spring Web, Spring Data JPA, MySQL Driver

## 🏗 Project Architecture

The project follows a standard **Layered Architecture** to ensure separation of concerns and maintainability:

1.  **Controller Layer** (`com.interestratesimulator.controller`): Handles incoming HTTP requests, validates input, and returns responses.
2.  **Service Layer** (`com.interestratesimulator.service`): Contains the core business logic for interest calculation and comparison.
3.  **Model Layer** (`com.interestratesimulator.model`): Defines the data structures (DTOs) for requests and responses.

## 📂 Folder Structure

```text
interest-rate-simulator/
├── pom.xml                        # Maven dependencies and build configuration
├── src
│   └── main
│       └── java
│           └── com
│               └── interestratesimulator
│                   ├── InterestRateSimulatorApplication.java  # Main entry point
│                   ├── controller
│                   │   └── InterestImpactController.java      # REST Controller
│                   ├── entity
│                   │   └── InterestCalculation.java           # JPA Entity
│                   ├── model
│                   │   ├── InterestRequest.java               # Request DTO
│                   │   └── InterestResponse.java              # Response DTO
│                   ├── repository
│                   │   └── InterestCalculationRepository.java # JPA Repository
│                   └── service
│                       └── InterestImpactService.java         # Business Logic
└── target/                        # Compiled build artifacts
```

## 📝 Prerequisites

Ensure you have the following installed on your local machine:

-   **Java Development Kit (JDK)**: Version 17 or higher.
-   **Maven**: Version 3.6.0 or higher.
-   **MySQL Server**: Version 8.0 or higher.
-   **Postman** (Optional): For API testing.

## ⚙️ Installation & Setup

1.  **Clone the Repository** (if using git):
    ```bash
    git clone <repository-url>
    cd interest-rate-simulator
    ```

2.  **Configure Database**:
    *   Ensure MySQL is running.
    *   Create the database:
        ```sql
        CREATE DATABASE interestdb;
        ```
    *   Update `src/main/resources/application.properties` with your MySQL credentials (if different from default):
        ```properties
        spring.datasource.username=root
        spring.datasource.password=12345Shree
        ```

3.  **Build the Project**:
    ```bash
    mvn clean install
    ```

4.  **Run the Application**:
    ```bash
    mvn spring-boot:run
    ```
    The application will start on **port 8080**.

## 📖 API Documentation

### Calculate Interest Impact

Calculates the maturity amounts and the difference based on the provided interest rates.

-   **Endpoint**: `/api/interest-impact/calculate`
-   **Method**: `POST`
-   **Content-Type**: `application/json`

#### Request Body

| Field | Type | Description | Example |
| :--- | :--- | :--- | :--- |
| `principal` | `double` | The initial investment amount. Must be > 0. | `500000` |
| `currentRate` | `double` | The current annual interest rate (in %). Must be >= 0. | `7` |
| `newRate` | `double` | The proposed new annual interest rate (in %). Must be >= 0. | `6` |
| `years` | `int` | The investment duration in years. Must be > 0. | `3` |

**Example JSON:**
```json
{
  "principal": 500000,
  "currentRate": 7,
  "newRate": 6,
  "years": 3
}
```

#### Response Body

| Field | Type | Description |
| :--- | :--- | :--- |
| `oldMaturityAmount` | `double` | Maturity value at the current rate. |
| `newMaturityAmount` | `double` | Maturity value at the new rate. |
| `difference` | `double` | The monetary difference (`new` - `old`). |
| `message` | `String` | Impact description. |

**Example JSON:**
```json
{
    "oldMaturityAmount": 612522.50,
    "newMaturityAmount": 595508.00,
    "difference": -17014.50,
    "message": "Interest rate decrease results in lower returns."
}
```

#### Error Response (400 Bad Request)
If inputs are invalid:
```text
Invalid input parameters.
```

## 🧪 Testing

### Option 1: Using cURL

Open your terminal and run:

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

### Option 2: Using Postman

1.  **Open Postman** and create a new request.
2.  Set the **HTTP Method** to `POST`.
3.  Enter the **URL**: `http://localhost:8080/api/interest-impact/calculate`.
4.  Switch to the **Body** tab.
5.  Select **raw** -> **JSON**.
6.  Paste the Request Body JSON (from the API Documentation section).
7.  Click **Send**.
