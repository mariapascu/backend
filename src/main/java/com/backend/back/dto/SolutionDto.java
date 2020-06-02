package com.backend.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonComponent
public class SolutionDto {
    private String unknownProperty;
    private Float solution;
    private List<List<String>> solutionSteps;
}

