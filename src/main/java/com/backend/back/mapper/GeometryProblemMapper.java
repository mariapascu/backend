package com.backend.back.mapper;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.model.GeometryProblem;
import com.backend.back.model.Student;
import com.backend.back.model.geometry.GeometricFigure;
import com.backend.back.model.geometry.solver.RectangularParallelepipedSolver;
import org.springframework.beans.factory.annotation.Autowired;
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
        GeometricFigure geometricFigure = new GeometricFigure();
        geometricFigure.setFigureName(dto.getFigureName());
        dto.getPropertyMap().forEach((property, value) -> geometricFigure.getDetails().put(property, value));
        entity.setGeometricFigure(geometricFigure);
        entity.setUnknownProperty(dto.getUnknownProperty());
        return entity;
    }

    public GeometryProblemDto toDto(GeometryProblem entity) {
        GeometryProblemDto dto = new GeometryProblemDto();
        dto.setUserId(entity.getStudent().getStudentId());
        dto.setFigureName(entity.getGeometricFigure().getFigureName());
        dto.setPropertyMap(new HashMap<>());
        entity.getGeometricFigure().getDetails().forEach((property, value) -> dto.getPropertyMap().put(property, value));
        dto.setUnknownProperty(entity.getUnknownProperty());
        return dto;
    }
}
