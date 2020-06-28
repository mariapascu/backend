package com.backend.back.service;

import com.backend.back.dto.CustomGeometryShapeDto;
import com.backend.back.mapper.CustomGeometryShapeMapper;
import com.backend.back.repository.CustomGeometricShapeRepository;
import com.backend.back.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan
public class CustomGeometryShapeServiceImpl implements CustomGeometryShapeService {
    @Autowired
    private CustomGeometricShapeRepository shapeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CustomGeometryShapeMapper shapeMapper;

    @Override
    public void saveShape(CustomGeometryShapeDto shapeDto) {

    }

    @Override
    public List<CustomGeometryShapeDto> getShapesByUserId(Long userId) {
        return null;
    }

    @Override
    public void deleteShape(Long shapeId) {

    }
}
