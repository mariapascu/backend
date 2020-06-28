package com.backend.back.service;

import com.backend.back.dto.CustomGeometryShapeDto;

import java.util.List;

public interface CustomGeometryShapeService {
    void saveShape(CustomGeometryShapeDto shapeDto);
    List<CustomGeometryShapeDto> getShapesByUserId(Long userId);
    void deleteShape(Long shapeId);
}
