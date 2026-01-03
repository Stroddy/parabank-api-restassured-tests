# ParaBank API – Smoke Notes

## LOGIN
GET /login/{username}/{password}

pathParams:
- username
- password

response:
- Customer object
- customerId = $.id

---

## CUSTOMER
GET /customers/{customerId}

pathParams:
- customerId

response:
- Customer object

---

## CUSTOMER ACCOUNTS
GET /customers/{customerId}/accounts

pathParams:
- customerId

response:
- array of Account
- accountId = $[0].id

---

## ACCOUNT
GET /accounts/{accountId}

pathParams:
- accountId

response:
- Account object