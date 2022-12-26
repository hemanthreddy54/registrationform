package com.hemanth.registrationform.controllers;

import ch.qos.logback.core.model.Model;
import com.hemanth.registrationform.models.Student;
import com.hemanth.registrationform.repositories.StudentRepository;
import com.hemanth.registrationform.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/hello")
    public String hello() {
        return "welcome to the registration form app";
    }

    @GetMapping("/register")
    public String registrationForm() {
        String htmlForm = """
                <html>
                  <head>
                    <title>Student Registration</title>
                  </head>
                  <body>
                    <h1>Student Registration</h1>
                    <form action="/savestudent" method="post">
                      <label for="first-name">First Name:</label><br>
                      <input type="text" id="first-name" name="firstName"><br>
                      <label for="last-name">Last Name:</label><br>
                      <input type="text" id="last-name" name="lastName"><br>
                      <label for="email">Email:</label><br>
                      <input type="email" id="email" name="email"><br>
                      <label for="phoneNumber">PhoneNumber:</label><br>
                      <input type="phoneNumber" id="phoneNumber" name="phoneNumber"><br>
                      <label for="gender">Gender:</label><br>
                      <input type="gender" id="gender" name="gender"><br>
                      <label for="dob">DOB:</label><br>
                      <input tyoe="dob" id="dob" name="dob"><br>
                      <input type="submit" value="Submit">
                    </form>
                  </body>
                </html>
                                
                """;
        return htmlForm;

    }

    @PostMapping("/savestudent")
    public Student saveStudent(@ModelAttribute Student student) {

        return studentService.save(student);


    }

    @GetMapping("/students/all")
    public List<Student> getstudents() {
        return studentService.getAllStudents();

    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id);
    }
    @PostMapping("/students/update")
    public Student updateStudent(@RequestBody Student student){
       return studentService.save(student);
    }
    @PostMapping("/students/updateall")
    public List<Student> updateAll(@RequestBody List<Student> students ){
       return studentService.saveAll(students);
    }



}
