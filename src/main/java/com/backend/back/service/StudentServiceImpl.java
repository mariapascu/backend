package com.backend.back.service;

import com.backend.back.exception.CustomException;
import com.backend.back.model.Student;
import com.backend.back.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ComponentScan
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findAll().stream().filter(s -> s.getEmail().equals(email)).findFirst();
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findAll().stream().filter(s -> s.getStudentId().equals(studentId)).findFirst();
    }
}
