package com.backend.back.mapper;

import com.backend.back.dto.MultipleGeometryProblemsDto;
import com.backend.back.model.GeometryProblem;
import com.backend.back.model.geometry.GeometricShape;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MultipleGeometryProblemsMapper {
    public List<GeometryProblem> toModel(MultipleGeometryProblemsDto dto) {
        List<GeometryProblem> entity = new ArrayList<>();
        GeometricShape geometricShape = new GeometricShape();
        geometricShape.setShapeName(dto.getShapeName());
        dto.getPropertyMap().forEach((property, value) -> geometricShape.getDetails().put(property, value));
        for (String unknownProperty : dto.getUnknownProperties()) {
            GeometryProblem gp = new GeometryProblem();
            gp.setGeometricShape(geometricShape);
            gp.setUnknownProperty(unknownProperty);
            entity.add(gp);
        }
        return entity;
    }
}
