package com.backend.back.controller;

import com.backend.back.model.Teacher;
import com.backend.back.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/add")
    public void addTeachers() {

    }

    @GetMapping("/getAll")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }



}
