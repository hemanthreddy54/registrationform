package com.hemanth.registrationform.services;

import com.hemanth.registrationform.models.Course;
import com.hemanth.registrationform.models.Student;
import com.hemanth.registrationform.repositories.CourseRepository;
import com.hemanth.registrationform.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public Course save(Course course) {
        courseRepository.save(course);
        return course;

    }


    public List<Course> saveAll(List<Course> courses) {
        courseRepository.saveAll(courses);
        return courses;
    }

}
