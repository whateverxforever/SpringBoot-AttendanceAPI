# SpringBoot-AttendanceAPI
**An attendance API made in SpringBoot(JAVA)☕.**
## 🛠 How to Build
Download the project in your JAVA-IDE and it should build itself automatically(make sure you have maven builder). After the project has been built use `Shift+F10` to run the API at `http://localhost:8080`. Then you can test the API using software like [**Postman**](https://www.postman.com/).
## 📂 Folder Structure
After the project has been built, the following project structure should emerge
```
demo
|-- idea
|-- .mvn
|-- src
  |--main
    |-- java
      |-- com.example.demo
        |-- api
          |-- AttendanceController
          |-- CourseController
          |-- StudentController
        |-- dao
          |-- AttendanceDao
          |-- AttendanceDataAccessService
          |-- CourseDao
          |-- CourseDataAccessService
          |-- StudentController  
          |-- StudentDataAccessService 
        |-- model
          |-- Attendance
          |-- Course
          |-- Student
        |-- service
          |-- AttendanceService
          |-- CourseService
          |-- StudentService
        |-- DemoApplication
    |-- resources
  |-- test
|-- target
|-- pom.xml
    
```
## ⛑ Architecture
This project is based on **MVC** Architecture (Models, Views and Controllers). Since we are using **Spring Framework** this architecture is a bit modified. There is a new layer of DataAccessService which acts in middle of Models and Controllers.

