package com.backend.back.service;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.mapper.GeometryProblemMapper;
import com.backend.back.mapper.SolutionMapper;
import com.backend.back.model.GeometryProblem;
import com.backend.back.model.Student;
import com.backend.back.repository.GeometricFigureRepository;
import com.backend.back.repository.GeometryProblemRepository;
import com.backend.back.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class GeometryProblemServiceImpl implements GeometryProblemService {
    @Autowired
    private GeometryProblemRepository geometryProblemRepository;
    @Autowired
    private GeometricFigureRepository geometricFigureRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private GeometryProblemMapper geometryProblemMapper;
    @Autowired
    private SolutionMapper solutionMapper;


    @Override
    public void saveProblem(GeometryProblemDto geometryProblemDto) {
        Optional<Student> student = studentService.getStudentById(geometryProblemDto.getUserId());
        if (student.isPresent()) {
            GeometryProblem geometryProblem = geometryProblemMapper.toModel(geometryProblemDto, student.get());
            geometricFigureRepository.save(geometryProblem.getGeometricFigure());
            geometryProblemRepository.save(geometryProblem);
        }
    }

    @Override
    public SolutionDto solveProblem(GeometryProblemDto geometryProblemDto) {
        GeometryProblem geometryProblem = geometryProblemMapper.toModel(geometryProblemDto);
        SolutionDto solutionDto = solutionMapper.toDto(geometryProblem);
        return solutionDto;
    }

    @Override
    public List<SolutionDto> getProblemSolutionsByUserId(Long userId) {
        List<GeometryProblem> geometryProblems = geometryProblemRepository.findAll().stream().filter(gp -> gp.getStudent().getStudentId().equals(userId)).collect(Collectors.toList());
        List<SolutionDto> solutionList = new ArrayList<>();
        geometryProblems.forEach(gp -> solutionList.add(solutionMapper.toDto(gp)));
        return solutionList;
    }

    @Override
    public List<GeometryProblemDto> getProblemsByUserId(Long userId) {
        List<GeometryProblem> geometryProblems = geometryProblemRepository.findAll().stream().filter(gp -> gp.getStudent().getStudentId().equals(userId)).collect(Collectors.toList());
        List<GeometryProblemDto> geometryProblemList = new ArrayList<>();
        geometryProblems.forEach(gp -> geometryProblemList.add(geometryProblemMapper.toDto(gp)));
        return geometryProblemList;
    }
}
