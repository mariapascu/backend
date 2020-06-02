package com.backend.back.service;

import com.backend.back.exception.CustomException;
import com.backend.back.model.Teacher;
import com.backend.back.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ComponentScan
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    @Override
    public Optional<Teacher> getTeacherByEmail(String email) {
        return teacherRepository.findAll().stream().filter(t -> t.getEmail().equals(email)).findFirst();
    }
}
