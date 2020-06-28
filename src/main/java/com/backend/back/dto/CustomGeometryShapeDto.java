package com.backend.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonComponent
public class CustomGeometryShapeDto {
    private Long shapeId;
}
