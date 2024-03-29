package com.backend.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonComponent
public class GeometryProblemDto {
    private Long problemId;
    private Long userId;
    private String shapeName;
    private String unknownProperty;
    private Map<String, Float> propertyMap;
}
