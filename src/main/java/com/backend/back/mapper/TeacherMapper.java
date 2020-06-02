package com.backend.back.mapper;

import com.backend.back.dto.UserDto;
import com.backend.back.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher toEntity(UserDto dto) {
        Teacher entity = new Teacher();
        entity.setTeacherId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public UserDto toDto(Teacher entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getTeacherId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setRole("teacher");
        return dto;
    }


}
