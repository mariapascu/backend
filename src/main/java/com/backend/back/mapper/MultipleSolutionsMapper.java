package com.backend.back.mapper;

import com.backend.back.dto.MultipleSolutionsDto;
import com.backend.back.model.GeometryProblem;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class MultipleSolutionsMapper {
    public MultipleSolutionsDto toDto(List<Pair<GeometryProblem, Float>> geometryProblemsAndSolutions) {
        MultipleSolutionsDto dto = new MultipleSolutionsDto();
        dto.setPropertyMap(new HashMap<>());
        for (Pair<GeometryProblem, Float> gps : geometryProblemsAndSolutions) {
            dto.getPropertyMap().put(gps.getKey().getUnknownProperty(), gps.getValue());
        }
        return dto;
    }

}
