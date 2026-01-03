# ParaBank API Automation Tests

Automated API tests for the demo **ParaBank API** (Parasoft) using:

- **Java 17**
- **JUnit 5**
- **Rest Assured**
- **Maven**

The project follows a step-by-step approach: starting with a working **end-to-end smoke test** and then gradually improving structure, assertions, and reusability.

---

## ✅ Implemented Functionality

### Smoke Flow (End-to-End)

Implemented a basic smoke scenario covering the main business flow:

- `GET /login/{username}/{password}` → extract `customerId`
- `GET /customers/{customerId}` → validate customer endpoint
- `GET /customers/{customerId}/accounts` → validate accounts list is not empty → extract `accountId`
- `GET /accounts/{accountId}` → validate account details

Validations include:
- HTTP status code checks (`200`)
- Accounts list is not empty
- Data consistency:
    - returned `account.id` equals requested `accountId`
    - returned `account.customerId` equals previously extracted `customerId`
- Presence of key fields (e.g. `balance`)

---

## 🔐 Credentials

Credentials are provided via environment variables and are **not committed** to the repository.

Create a `.env` file in the project root (see `.env example`):

```env
PARABANK_USERNAME=john
PARABANK_PASSWORD=demo
```
---
## 📂 Project Structure
```text
src/
├── main/
│   └── java/
│       ├── clients/
│       │   ├── BaseClient.java
│       │   ├── AuthClient.java
│       │   ├── CustomersClient.java
│       │   └── AccountsClient.java
│       ├── config/
│       │   └── ApiConfig.java
│       └── specs/
│           └── RequestSpecFactory.java
└── test/
    └── java/
        ├── smoke_tests/
        │   └── LoginSmokeTest.java
        └── utils/
            └── AuthCredentials.java

.env
.env example
pom.xml
.gitignore
README.md
```
---

## 🚀 Running Tests

### Prerequisites
- Java 17
- Maven

### Setup credentials
Create a `.env` file in the project root (see `.env example`).

### Run all tests
```bash
mvn test
```


## 🧰 Tech Stack

| Tool | Purpose |
|------|----------|
| **RestAssured** | API requests & response handling |
| **JUnit 5** | Test framework |
| **Maven** | Build & dependency management |

---
## 🛠 Planned Improvements

- Refactor assertions using assertAll()
- Extract endpoints into constants (avoid repeated hardcoded paths)
- Add positive/negative tests for key endpoints
- Add Response Specs / validation helpers
- Add Allure reporting
- Expand coverage beyond smoke flow
---

## 👤 Author

**Ahmed**