package com.hemanth.registrationform.controllers;

import com.hemanth.registrationform.models.Course;
import com.hemanth.registrationform.models.Student;
import com.hemanth.registrationform.repositories.CourseRepository;
import com.hemanth.registrationform.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/register/course")
    public String registrationCourseForm() {
        String htmlForm = """
                <html>
                  <head>
                    <title>Course Registration</title>
                  </head>
                  <body>
                    <h1>Course Registration</h1>
                    <form action="/savecourse" method="post">
                      <label for="course-name">Course Name:</label><br>
                      <input type="text" id="course-name" name="courseName"><br>
                      <label for="branch-name">Branch Name:</label><br>
                      <input type="text" id="branch-name" name="branchName"><br>
                      <label for="teacher-name">Teacher Name:</label><br>
                      <input type="teachername" id="teacher-name" name="teacherName"><br>
                      
                     <input type="submit" value="Submit">
                    </form>
                  </body>
                </html>
                                
                """;
        return htmlForm;

    }

    @PostMapping("/savecourse")
    public Course saveCourse(@ModelAttribute Course course) {
        courseRepository.save(course);
        return course;


    }

    @GetMapping("/Courses/all")
    public List<Course> getCourses() {
        return courseRepository.findAll();

    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {

        return courseRepository.findById(id).get();
    }
    @PostMapping("/courses/update")
    public Course updateCourse(@RequestBody Course course){
        courseRepository.save(course);

        return course;
    }
    @PostMapping("/courses/updateall")
    public List<Course> updateall(@RequestBody List<Course> courses ){
        courseRepository.saveAll(courses);
        return courses;
    }




}
