
# VHO Activ - Backend REST API

*Status:* In Development 🚧  
A backend system built with Spring Boot (Java 21) and Oracle 23ai for managing volunteer activities, attendance,
tasks, trainings, committees, evaluations, reports, and apologies.

This is a pure *RESTful API* project with no frontend. It offers organized endpoints for data creation, retrieval,
and basic updates. More advanced features (deletion, role-based access, and security) are planned in future phases.

## 🔧 Tech Stack

- *Java 21*
- *Spring Boot*
- *Oracle 23ai*
- *Maven*


## 📦 Features (Current)

- Volunteer registration & data retrieval
- Activity check-in / check-out
- Apology & report submission
- Committee, training, task, evaluation, and attendance tracking
- Dashboard endpoints for admin operations

## 🛠 Planned Enhancements

- Role-based access control (Admin, HR, Volunteer, etc.)
- Authentication & Authorization (Spring Security)
- Extended update & delete operations
- Swagger API documentation

## ▶ How to Run

1. Configure Oracle DB credentials in application.properties
2. Run:
   ```bash
   mvn clean install
   java -jar target/your-app.jar

3. Access API at http://localhost:8080


🧪 API Testing

Use Postman or curl to interact with endpoints:

GET /volunteers/{id}

POST /activities/{id}/check-in/{volunteerId}

POST /reports

GET /committees/{id}/tasks (See controller classes for full list)


📄 License

This project is for educational use only.
All rights reserved © 2025 Nice.