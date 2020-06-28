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
public class MultipleSolutionsDto {
    Map<String, Float> propertyMap;
}
