# 🎓 Career Placement Recommender

A modular career recommendation system built using Spring Core, Strategy Pattern, and JSR-380 validation.

---

# 🚀 Project Overview

Career Placement Recommender is a Spring Core–based console application that suggests the most suitable career domain (IT, Core, Management, Finance) based on a student's CGPA, skills, and profile.
It uses Strategy Pattern, Dependency Injection, and Hibernate Validator to deliver accurate, maintainable, and scalable recommendations.

---

# 🧩 Key Features

⚙️ Strategy Pattern for dynamic placement recommendation (IT/Core/Management/Finance).

🧵 Spring Core Dependency Injection with @Component, @Service, and @Autowired.

✔️ JSR-380 (Hibernate Validator) for validating student inputs.

🧱 Extensible architecture — easily add new placement strategies without modifying existing code.

🖥️ Menu-driven console UI with clean prompts and colored output.

📦 Maven-based project with organized dependencies and packaging.

---

# 🏗️ Tech Stack

Java 17+

Spring Core (Annotation-based configuration)

Strategy Pattern

Hibernate Validator (JSR-380)

Maven

---
# 📁 Project Structure

src/main/java

 └── com.cs
 
      ├── config
      
      │     └── AppConfig.java
      
      ├── model
      
      │     └── Student.java
      
      ├── service
      
      │     └── PlacementService.java
      
      ├── strategy
      
      │     ├── ITPlacementStrategy.java
      
      │     ├── CorePlacementStrategy.java
      
      │     ├── ManagementPlacementStrategy.java
      
      │     └── FinancePlacementStrategy.java
      
      └── main
      
            └── PlacementProgramTest.java

---

# 📝 Sample Output

==============================

 CAREER PLACEMENT RECOMMENDER 

==============================

Choose Placement Type:
1. IT
2. Core
3. Management
4. Finance
Enter option: Enter your choice (1-4): 

Enter Student Details:
Name      : chaitali
CGPA      : 8.2
Skills    : java,spring,sql

===== IT Placement Result =====

Name: chaitali

Eligible: YES

Salary Offered: 532000.00

Required Skills: Java, SQL, Spring

---

# 🛠️ Future Enhancements

Add resume formatting suggestions

Add REST API version using Spring Boot

Add ML-based smart scoring for predictions
