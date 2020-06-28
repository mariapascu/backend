package com.backend.back.mapper;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.model.GeometryProblem;
import com.backend.back.model.Student;
import com.backend.back.model.geometry.GeometricShape;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class GeometryProblemMapper {
    public GeometryProblem toModel(GeometryProblemDto dto, Student student) {
        GeometryProblem entity = toModel(dto);
        entity.setStudent(student);
        return entity;
    }

    public GeometryProblem toModel(GeometryProblemDto dto) {
        GeometryProblem entity = new GeometryProblem();
        GeometricShape geometricShape = new GeometricShape();
        geometricShape.setShapeName(dto.getShapeName());
        dto.getPropertyMap().forEach((property, value) -> geometricShape.getDetails().put(property, value));
        entity.setGeometricShape(geometricShape);
        entity.setUnknownProperty(dto.getUnknownProperty());
        return entity;
    }

    public GeometryProblemDto toDto(GeometryProblem entity) {
        GeometryProblemDto dto = new GeometryProblemDto();
        dto.setProblemId(entity.getGeometryProblemId());
        dto.setUserId(entity.getStudent().getStudentId());
        dto.setShapeName(entity.getGeometricShape().getShapeName());
        dto.setPropertyMap(new HashMap<>());
        entity.getGeometricShape().getDetails().forEach((property, value) -> dto.getPropertyMap().put(property, value));
        dto.setUnknownProperty(entity.getUnknownProperty());
        return dto;
    }
}
