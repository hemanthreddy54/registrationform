package com.hemanth.registrationform.repositories;

import com.hemanth.registrationform.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
