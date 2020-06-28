package com.backend.back.service;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.dto.MultipleGeometryProblemsDto;
import com.backend.back.dto.MultipleSolutionsDto;
import com.backend.back.dto.SolutionDto;
import com.backend.back.exception.CustomException;
import com.backend.back.mapper.GeometryProblemMapper;
import com.backend.back.mapper.MultipleGeometryProblemsMapper;
import com.backend.back.mapper.MultipleSolutionsMapper;
import com.backend.back.mapper.SolutionMapper;
import com.backend.back.model.GeometryProblem;
import com.backend.back.model.Student;
import com.backend.back.model.geometry.GeometricShape;
import com.backend.back.model.geometry.solver.Step;
import com.backend.back.repository.GeometricShapeRepository;
import com.backend.back.repository.GeometryProblemRepository;
import com.backend.back.repository.StudentRepository;
import javafx.util.Pair;
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
    private GeometricShapeRepository geometricShapeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GeometryProblemMapper geometryProblemMapper;
    @Autowired
    private SolutionMapper solutionMapper;
    @Autowired
    private MultipleGeometryProblemsMapper multipleGeometryProblemsMapper;
    @Autowired
    private MultipleSolutionsMapper multipleSolutionsMapper;

    @Override
    public void saveProblem(GeometryProblemDto geometryProblemDto) {
        Optional<Student> student = studentRepository.findAll().stream().filter(s -> s.getStudentId().equals(geometryProblemDto.getUserId())).findFirst();
        if (student.isPresent()) {
            GeometryProblem geometryProblem = geometryProblemMapper.toModel(geometryProblemDto, student.get());
            geometricShapeRepository.save(geometryProblem.getGeometricShape());
            geometryProblemRepository.save(geometryProblem);
        }
    }

    @Override
    public SolutionDto solveProblem(GeometryProblemDto geometryProblemDto) throws CustomException {
        GeometryProblem geometryProblem = geometryProblemMapper.toModel(geometryProblemDto);
        Pair<Float, List<Step>> solution = geometryProblem.getSolution();
        SolutionDto solutionDto = solutionMapper.toDto(geometryProblem, solution);
        return solutionDto;
    }

    @Override
    public List<SolutionDto> getProblemSolutionsByUserId(Long userId) throws CustomException {
        List<GeometryProblem> geometryProblems = geometryProblemRepository.findAll().stream().filter(gp -> gp.getStudent().getStudentId().equals(userId)).collect(Collectors.toList());
        List<SolutionDto> solutionList = new ArrayList<>();
        for (GeometryProblem gp : geometryProblems) {
            solutionList.add(solutionMapper.toDto(gp, gp.getSolution()));
        }
        return solutionList;
    }

    @Override
    public List<GeometryProblemDto> getProblemsByUserId(Long userId) {
        List<GeometryProblem> geometryProblems = geometryProblemRepository.findAll().stream().filter(gp -> gp.getStudent().getStudentId().equals(userId)).collect(Collectors.toList());
        List<GeometryProblemDto> geometryProblemList = new ArrayList<>();
        geometryProblems.forEach(gp -> geometryProblemList.add(geometryProblemMapper.toDto(gp)));
        return geometryProblemList;
    }

    @Override
    public MultipleSolutionsDto solveMultipleProblems(MultipleGeometryProblemsDto geometryProblemsDto) throws CustomException {
        List<GeometryProblem> geometryProblems = multipleGeometryProblemsMapper.toModel(geometryProblemsDto);
        List<Pair<GeometryProblem, Float>> geometryProblemsAndSolutions = new ArrayList<>();
        for (GeometryProblem geometryProblem : geometryProblems) {
            geometryProblemsAndSolutions.add(new Pair<>(geometryProblem, geometryProblem.getSolution().getKey()));
        }
        MultipleSolutionsDto multipleSolutionsDto = multipleSolutionsMapper.toDto(geometryProblemsAndSolutions);
        return multipleSolutionsDto;
    }

    @Override
    public void deleteProblemById(Long problemId) {
        GeometryProblem geometryProblem = geometryProblemRepository.getOne(problemId);
        GeometricShape geometricShape = geometryProblem.getGeometricShape();
        geometryProblemRepository.delete(geometryProblem);
        geometricShapeRepository.delete(geometricShape);
    }
}
