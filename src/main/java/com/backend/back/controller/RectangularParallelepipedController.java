package com.backend.back.controller;

import com.backend.back.model.geometry.RectangularParallelepiped;
import com.backend.back.model.geometry.solver.RectangularParallelepipedSolver;
import com.backend.back.model.geometry.solver.Solver;
import com.backend.back.repository.RectangularParallelepipedRepository;
import com.backend.back.repository.RegularSquarePyramidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/para")
public class RectangularParallelepipedController {
    @Autowired
    private RectangularParallelepipedRepository rectangularParallelepipedRepository;
    @Autowired
    private RegularSquarePyramidRepository repo;

    @GetMapping("/try")
    public void trySmth() {
//        RectangularParallelepiped p = new RectangularParallelepiped(0L, 3F, 0F, 1F, 0F, 3F, 0F, 0F, 0F, "cm");
//        RectangularParallelepipedHelper s = new RectangularParallelepipedHelper(p);
//
//        s.solve();
        RectangularParallelepiped p = new RectangularParallelepiped();
        p.getDetails().put("length", 2F);
        p.getDetails().put("height", 3F);
        p.getDetails().put("baseSurface", 4F);
        Solver s = new RectangularParallelepipedSolver(p, "volume");
        rectangularParallelepipedRepository.save(p);
        s.solve();
    }
}
