package com.backend.back.service;

import com.backend.back.dto.UserDto;
import com.backend.back.exception.CustomException;
import com.backend.back.model.Student;

import java.util.Optional;

public interface UserService {
    Student createStudent(Student student);
    UserDto login(String email, String password) throws CustomException;
    UserDto signup(UserDto userDto) throws CustomException;
    Optional<Student> getStudentByEmail(String email);
    Optional<Student> getStudentById(Long studentId);
    boolean emailIsInUse(String email);
}
