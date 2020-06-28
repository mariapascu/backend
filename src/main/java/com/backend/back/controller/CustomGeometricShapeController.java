package com.backend.back.controller;

import com.backend.back.dto.CustomGeometryShapeDto;
import com.backend.back.service.CustomGeometryShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomGeometricShapeController {
    @Autowired
    private CustomGeometryShapeService shapeService;

    public ResponseEntity saveProblem(CustomGeometryShapeDto shapeDto) {
        return null;
    }

    public ResponseEntity getShapesByUserId(CustomGeometryShapeDto shapeDto) {
        return null;
    }
}
