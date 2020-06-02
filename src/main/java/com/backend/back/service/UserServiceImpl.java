package com.backend.back.service;

import com.backend.back.repository.StudentRepository;
import com.backend.back.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class UserServiceImpl implements UserService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public boolean emailIsInUse(String email) {
        if (studentRepository.findAll().stream().noneMatch(s -> s.getEmail().equals(email))) {
            return teacherRepository.findAll().stream().anyMatch(t -> t.getEmail().equals(email));
        }
        return true;
    }
}
