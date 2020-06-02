package com.backend.back.controller;

import com.backend.back.dto.GeometryProblemDto;
import com.backend.back.model.geometry.GeometricFigure;
import com.backend.back.model.geometry.solver.RectangularParallelepipedSolver;
import com.backend.back.model.geometry.solver.Solver;
import com.backend.back.repository.RectangularParallelepipedRepository;
import com.backend.back.repository.RegularSquarePyramidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/problem")
public class RectangularParallelepipedController {
    @Autowired
    private RectangularParallelepipedRepository rectangularParallelepipedRepository;
    @Autowired
    private RegularSquarePyramidRepository repo;

    @PostMapping("/")
    public ResponseEntity solveProblem(@RequestBody GeometryProblemDto geometryProblemDto) {
        System.out.println(geometryProblemDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/try")
    public void trySmth() {
//        RectangularParallelepiped p = new RectangularParallelepiped(0L, 3F, 0F, 1F, 0F, 3F, 0F, 0F, 0F, "cm");
//        RectangularParallelepipedHelper s = new RectangularParallelepipedHelper(p);
//
//        s.solve();
        GeometricFigure p = new GeometricFigure();
        p.getDetails().put("length", 2F);
        p.getDetails().put("height", 3F);
        p.getDetails().put("baseSurface", 4F);
        Solver s = new RectangularParallelepipedSolver(p, "volume");
        rectangularParallelepipedRepository.save(p);
        s.solve();
    }
}
