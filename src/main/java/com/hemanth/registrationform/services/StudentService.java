package com.hemanth.registrationform.services;

import com.hemanth.registrationform.models.Student;
import com.hemanth.registrationform.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student save(Student student) {
        studentRepository.save(student);
        return student;

    }


    public List<Student> saveAll(List<Student> students) {
        studentRepository.saveAll(students);
        return students;
    }

}
