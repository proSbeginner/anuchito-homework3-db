### How to Run
#### Run on mac
```
./gradlew bootRun
```
### REST APIs
#### หา Loan ทั้งหมด
```
curl localhost:8080/api/loans
```
#### หา Loan จาก Loan ID
```
curl localhost:8080/api/loans/L001
```
#### หา Person ทั้งหมด (People)
```
curl localhost:8080/api/people
```
#### หา Person จาก ​Person ID
```
curl localhost:8080/api/people/P002
```
#### หา Person จาก Loan ID ของเขา/หล่อน (แปลกๆ)
```
curl localhost:8080/api/people/loans/{loanId}
```
