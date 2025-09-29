# 📚 Student Management REST API

A **Spring Boot REST API** project for managing students.  
It supports full **CRUD operations**: Create, Read, Update, and Delete students, with proper request/response handling.

---

## 🚀 Features
- Create a new student
- Retrieve all students or by ID
- Update or replace student details
- Delete student by ID
- RESTful design with proper HTTP methods (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`)
- Integrated with **JPA & Hibernate**
- Tested with **Postman Collection**

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **MySQL / H2 Database**
- **Lombok**
- **Postman** for testing APIs

---

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <your-repo-link>
   cd student-management
   ```

2. **Configure Database**  
   In `application.properties`:

   ```properties
   spring.application.name=StudentManagement
   spring.datasource.url=jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   # JPA/Hibernate
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

   *(For in-memory testing, you can use H2 instead — see screenshot below)*

3. **Run the project**
   ```bash
   mvn spring-boot:run
   ```

4. The API will be available at:
   ```
   http://localhost:8080/api/students
   ```

---

## 📸 Screenshots


### 🔹 Save Student
![Save Student](https://raw.githubusercontent.com/Abhikanade17112002/Spring-Boot-Project-/dev/src/main/resources/static/Save_Student.png)

### 🔹 Get All Students
![Get All Students](https://raw.githubusercontent.com/Abhikanade17112002/Spring-Boot-Project-/dev/src/main/resources/static/Get_All_Students.png)

### 🔹 Get Student With Id
![Get Student With Id](https://raw.githubusercontent.com/Abhikanade17112002/Spring-Boot-Project-/dev/src/main/resources/static/Get_Student_With_Id.png)

### 🔹 Update Student With Id
![Update Student With Id](https://raw.githubusercontent.com/Abhikanade17112002/Spring-Boot-Project-/dev/src/main/resources/static/Update_Student_With_Id.png)

### 🔹 Replace Student With Id
![Replace Student With Id](https://raw.githubusercontent.com/Abhikanade17112002/Spring-Boot-Project-/dev/src/main/resources/static/Replace_Student_With_Id.png)

### 🔹 Delete Student With Id
![Delete Student With Id](https://raw.githubusercontent.com/Abhikanade17112002/Spring-Boot-Project-/dev/src/main/resources/static/Delete_Student_With_Id.png)


---

## 📌 API Endpoints

All endpoints are **prefixed with** `/api/students`.

| Method | Endpoint                    | Description                  |
|--------|-----------------------------|------------------------------|
| `GET`  | `/api/students`             | Get all students             |
| `GET`  | `/api/students/{id}`        | Get student by ID            |
| `POST` | `/api/students`             | Save a new student           |
| `PUT`  | `/api/students/{id}`        | Replace a student by ID      |
| `PATCH`| `/api/students/{id}`        | Update student partially     |
| `DELETE`| `/api/students/{id}`       | Delete student by ID         |

---

## 🧪 Postman Collection
A full Postman collection is included for testing the API.

👉 [Download Postman Collection](Student%20Management%20Project.postman_collection.json)  

You can import it into Postman to test all endpoints directly.

---

## 📧 Author
👤 **Abhishek Rangnath Kanade**  
📍 Pune, India  
💼 MERN / Java Full Stack Developer  
