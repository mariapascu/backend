package com.backend.back.controller;

import com.backend.back.dto.StudentDto;
import com.backend.back.mapper.StudentMapper;
import com.backend.back.model.Student;
import com.backend.back.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/add")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        Student newStudent = studentService.createStudent(student);
        StudentDto newStudentDto = studentMapper.toDto(newStudent);
        return ResponseEntity.ok(newStudentDto);
    }
}
