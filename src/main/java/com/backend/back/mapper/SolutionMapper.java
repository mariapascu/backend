package com.backend.back.mapper;

import com.backend.back.dto.SolutionDto;
import com.backend.back.model.GeometryProblem;
import com.backend.back.model.geometry.solver.Step;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SolutionMapper {
    public SolutionDto toDto(GeometryProblem geometryProblem) {
        SolutionDto dto = new SolutionDto();
        dto.setUnknownProperty(geometryProblem.getUnknownProperty());
        var solution = geometryProblem.getSolution();
        dto.setSolution(solution.getKey());
        List<List<String>> solS = new ArrayList<>();
        for (Step s : solution.getValue()) {
            solS.add(s.getFormulas());
        }
        dto.setSolutionSteps(solS);
        return dto;
    }
}
