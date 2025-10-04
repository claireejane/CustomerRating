# 🌟 CustomerRatingApp

Java project practicing **custom exceptions**, **input validation**, and **error handling**.  
This program reads customer ratings and data from a file, validates them, and throws meaningful exceptions when invalid data is encountered.

---

## ✨ Features
- **CustomerRating**
  - Imports customer ratings and ages
  - Validates input ratings
  - Can trigger exceptions when invalid values are provided
- **InvalidRatingException**
  - Custom checked exception
  - Thrown when a rating is outside the valid range
- **CriticalDataException**
  - Custom checked exception
  - Represents a more severe issue (e.g., missing or corrupted data)
- **Customer** 
  - Class for customer
  - Has ages and ratings
  - Includes getters and setters

---

## 🚀 How to Run
1. Compile all classes:
   ```bash
   javac *.java
2. Run the driver:
   java CustomerRating
