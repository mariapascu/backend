package com.backend.back.controller;

import com.backend.back.dto.UserDto;
import com.backend.back.exception.CustomException;
import com.backend.back.mapper.StudentMapper;
import com.backend.back.mapper.TeacherMapper;
import com.backend.back.model.Student;
import com.backend.back.model.Teacher;
import com.backend.back.service.StudentService;
import com.backend.back.service.TeacherService;
import com.backend.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @PostMapping("/")
    public ResponseEntity signup(@RequestBody UserDto userDto) {
        if (userService.emailIsInUse(userDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomException("Email already in use!"));
        }
        if (userDto.getRole().equals("student")) {
            Student student = studentMapper.toEntity(userDto);
            Student newStudent = studentService.createStudent(student);
            UserDto newStudentDto = studentMapper.toDto(newStudent);
            return ResponseEntity.ok(newStudentDto);
        } else if (userDto.getRole().equals("teacher")) {
            Teacher teacher = teacherMapper.toEntity(userDto);
            Teacher newTeacher = teacherService.createTeacher(teacher);
            UserDto newTeacherDto = teacherMapper.toDto(newTeacher);
            return ResponseEntity.ok(newTeacherDto);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomException("Unknown role!"));
    }
}
