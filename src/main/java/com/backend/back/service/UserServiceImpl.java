package com.backend.back.service;

import com.backend.back.dto.UserDto;
import com.backend.back.exception.CustomException;
import com.backend.back.mapper.StudentMapper;
import com.backend.back.model.Student;
import com.backend.back.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ComponentScan
public class UserServiceImpl implements UserService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean emailIsInUse(String email) {
        return studentRepository.findAll().stream().anyMatch(s -> s.getEmail().equals(email));
    }

    @Override
    public UserDto login(String email, String password) throws CustomException {
        Optional<Student> student = getStudentByEmail(email);
        if (student.isPresent()) {
            if (student.get().getPassword().equals(password)) {
                return studentMapper.toDto(student.get());
            }
            throw new CustomException("Incorrect password!");
        }
        throw new CustomException("User does not exist!");
    }

    @Override
    public UserDto signup(UserDto userDto) throws CustomException {
        if (emailIsInUse(userDto.getEmail())) {
            throw new CustomException("Email already in use!");
        }
        if (userDto.getRole().equals("student")) {
            Student student = studentMapper.toEntity(userDto);
            Student newStudent = createStudent(student);
            return studentMapper.toDto(newStudent);
        }
        throw new CustomException("Unknown role!");
    }

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
