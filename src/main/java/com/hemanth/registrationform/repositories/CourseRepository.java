package com.hemanth.registrationform.repositories;

import com.hemanth.registrationform.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
