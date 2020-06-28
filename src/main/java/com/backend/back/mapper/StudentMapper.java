package com.backend.back.mapper;

import com.backend.back.dto.UserDto;
import com.backend.back.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(UserDto dto) {
        Student entity = new Student();
        entity.setStudentId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public UserDto toDto(Student entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getStudentId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPassword("");
        dto.setRole("student");
        return dto;
    }


}
