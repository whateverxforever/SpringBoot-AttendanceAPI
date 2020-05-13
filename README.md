# SpringBoot-AttendanceAPI
**A RESTful attendance API made in SpringBoot(JAVA)☕.**<br /><br />
**Author : Gaurav Acharya - 17BCE1120, Mohika Thampi - 17BCE1079 ✏**<br />
**Faculty: Dr. Sridevi S.**
## 🛠 How to Build
Download the project in your NetBeans/Eclipse/IntelliJ-IDE and it should build itself automatically(make sure you have maven builder). After the project has been built use `Shift+F10` to run the API at `http://localhost:8080`. Then you can test the API using software like [**Postman**](https://www.postman.com/). In case of error check **pom.xml** for dependencies.
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
### 🦴 Models
In models we define constructors of our classes along with their getters and setters. We also define the class methods and members. `@JsonProperty` is a Spring method to identify the incoming json data-body key-value pairs.
```java
public class Student {

    private final String id;
    private final String name;

    public Student(@JsonProperty("id") String id,
                   @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }
}

```
### 🏬 DAO
DAO stands for Data Access Object and is a layer, whose main purpose is to pull the data from the models and provide it to service layer or vice-versa. We implement the DAO by using **DAO Interfaces** and **AccessService classes**.

```java
public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(String id);

    int deleteStudentById(String id);

    int updateStudentById(String id, Student student);

}
```
> AccessServices act as our **virtual repositories**(in the below example I am using a List as a dummy database, but we can connect to services like **SQL** if required). Then we define our interface declarations in it.
```java
@Repository("studentDao")
public class StudentDataAccessService implements StudentDao{

    private static List<Student> DB = new ArrayList<>();

    @Override
    public int insertStudent(Student student) {
        DB.add(new Student(student.getId(), student.getName()));
        return 1;
    }
    
    @Override
    public Optional<Student> selectStudentById(String id) {
        return DB.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

  ....
 
}
```
### 🕴 Services
Services contain the **business logic** of our app, in Spring archtiecture it utilises the DAO's for the same. Business logic includes are post-processing and pre-processing data steps. In my app, there is no business logic required, so it just beccomes a one to one mapping between the controller and DAO.

```java
@Service
public class AttendanceService {

    private final AttendanceDao attendanceDao;

    @Autowired
    public AttendanceService(@Qualifier("attendanceDao") AttendanceDao attendanceDao) { this.attendanceDao = attendanceDao;}

    public int addAttendance(Attendance attendance){ return attendanceDao.insertAttendance(attendance);}
    
    ....
 }
```

### 🎮 Controllers
Controllers are define all the **routes** and their respective **request mappings**. This layer is the topmost layer(API side) and is responsible for managing all the **requests** and giving back the **responses**. You can map your endpoint path using `@RequestMapping`. If you want an app to consume the API you need to allow cross-origin at that `PORT` using `@CrossOrigin`

```java
@RequestMapping("api/attendance")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) { this.attendanceService = attendanceService; }

    @PostMapping
    public void addAttendance(@RequestBody Attendance attendance){
        attendanceService.addAttendance(attendance);
    }

    @PutMapping(path = "{id}")
    public void updateAttendanceById(@PathVariable("id") UUID id, @RequestBody Attendance attendance){
        attendanceService.updateAttendanceById(id, attendance);
    }
    .....
}
```
## 🛒 API
The API consists of three resources with their suitable methods:
 - Student
 - Course
 - Attendance
 
 These resources can be accessed and modified using the following end points:

<center>

| ENDPOINT            	| REQUEST            	|
|---------------------	|--------------------	|
| /api/student        	| GET, POST          	|
| /api/student/:id    	| GET, PATCH, DELETE 	|
| /api/course         	| GET, POST          	|
| /api/course/:id     	| GET, PATCH, DELETE 	|
| /api/attendance     	| GET, POST          	|
| /api/attendance/:id 	| GET, PATCH        	|

</center>

## 📨 Working with POSTMAN
Here I am sending a POST request to add a student in DB. You can do it similarly with the other resources and their methods.

![POSTMAN-QUERY](https://github.com/whateverxforever/SpringBoot-AttendanceAPI/blob/master/assets/postman1.PNG)
![POSTMAN-RESULT](https://github.com/whateverxforever/SpringBoot-AttendanceAPI/blob/master/assets/postman2.PNG)

## 💻 Using it in App
I built a **REACT App** to consume this API(haven't included it in repository since it's in JavaScript and outside the scope of the project). Here is a small GIF for the application.
![GIF-REACT](https://github.com/whateverxforever/SpringBoot-AttendanceAPI/blob/master/assets/working.gif)

