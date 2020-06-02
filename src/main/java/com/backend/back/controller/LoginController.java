package com.backend.back.controller;

import com.backend.back.dto.UserDto;
import com.backend.back.exception.CustomException;
import com.backend.back.mapper.StudentMapper;
import com.backend.back.mapper.TeacherMapper;
import com.backend.back.model.Student;
import com.backend.back.model.Teacher;
import com.backend.back.model.User;
import com.backend.back.service.StudentService;
import com.backend.back.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/{email}/{password}")
    public ResponseEntity login(@PathVariable String email, @PathVariable String password) {
        Optional<Student> student = studentService.getStudentByEmail(email);
        if (student.isPresent()) {
            if (student.get().getPassword().equals(password)) {
                return ResponseEntity.ok(studentMapper.toDto(student.get()));
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomException("Incorrect Password"));
            }
        }
        Optional<Teacher> teacher = teacherService.getTeacherByEmail(email);
        if (teacher.isPresent()) {
            if (teacher.get().getPassword().equals(password)) {
                return ResponseEntity.ok(teacherMapper.toDto(teacher.get()));
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomException("Incorrect Password"));
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomException("User does not exist"));
    }


}
