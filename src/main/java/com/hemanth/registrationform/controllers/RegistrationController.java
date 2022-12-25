package com.hemanth.registrationform.controllers;

import com.hemanth.registrationform.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @GetMapping("/hello")
    public String hello(){
        return "welcome to the registration form app";
    }
    @GetMapping("/register")
    public String registrationForm(){
        String htmlForm= """
                <html>
                  <head>
                    <title>Student Registration</title>
                  </head>
                  <body>
                    <h1>Student Registration</h1>
                    <form action="/register" method="post">
                      <label for="first-name">First Name:</label><br>
                      <input type="text" id="first-name" name="firstName"><br>
                      <label for="last-name">Last Name:</label><br>
                      <input type="text" id="last-name" name="lastName"><br>
                      <label for="email">Email:</label><br>
                      <input type="email" id="email" name="email"><br>
                      <input type="submit" value="Submit">
                    </form>
                  </body>
                </html>
                                
                """;
        return htmlForm;

    }
    @PostMapping("/register")
    public Student saveStudent(@ModelAttribute Student student){
        return student;


    }
}
