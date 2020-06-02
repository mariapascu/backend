package com.backend.back.service;

import com.backend.back.exception.CustomException;
import com.backend.back.model.Student;

import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);
    Optional<Student> getStudentByEmail(String email);
    Optional<Student> getStudentById(Long studentId);
}
