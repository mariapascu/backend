package com.backend.back.mapper;

import com.backend.back.dto.StudentDto;
import com.backend.back.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentDto dto) {
        Student entity = new Student();
        entity.setStudentId(dto.getStudentId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public StudentDto toDto(Student entity) {
        StudentDto dto = new StudentDto();
        dto.setStudentId(entity.getStudentId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        return dto;
    }


}
