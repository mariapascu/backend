package com.backend.back.service;

import com.backend.back.exception.CustomException;
import com.backend.back.model.Teacher;

import java.util.Optional;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    Optional<Teacher> getTeacherByEmail(String email);
}
