
# BMI Calculator & Diet Suggestor

A Java-based console application that allows users to register, log in, calculate BMI, store BMI history, track progress, and get automated diet suggestions based on their BMI category. The project integrates **JDBC** for database connectivity and uses **MySQL** for persistent storage of users and BMI records.

## 📌 Features

### ✅ User Management
- User Registration  
- User Login & Authentication  
- Input validation for email, password, age, gender, height & weight  

### ✅ BMI Calculation
- Quick BMI calculation (not saved)
- BMI calculation & saving records
- BMI history view
- Latest BMI comparison with previous record
- BMI category classification (Underweight, Normal, Overweight, Obese)

### ✅ Diet Suggestor
Automatically provides diet recommendations based on BMI category:
- Underweight diet plan  
- Normal healthy maintenance diet  
- Overweight weight-management plan  
- Obesity reduction diet plan  

### ✅ Database Features
- MySQL + JDBC integration  
- Users table & BMI records table  
- Prepared statements for secure queries  
- Exception handling  
- Complex SQL queries (Joins, Ranking, Aggregations)


## 📂 Project Structure
/src
└── cbp
├── UserConsoleApp.java
├── DBConnection.java
├── DietSuggestor.java
├── User.java
└── BMIRecord.java

/database
└── schema.sql



