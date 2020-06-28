package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricShape;

import java.util.List;
import java.util.Map;

public class RegularSquarePyramidSolver extends Solver {
    public RegularSquarePyramidSolver(GeometricShape geometricShape, String requiredInfo) {
        super(geometricShape, requiredInfo);
    }

    @Override
    public Map<String, List<Step>> getTheory() {
        return null;
    }
}
