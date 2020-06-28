package com.backend.back.utils;

import com.backend.back.exception.CustomException;
import com.backend.back.model.geometry.GeometricShape;
import com.backend.back.model.geometry.solver.*;

public class SolverFactory {
    public Solver getSolver(GeometricShape geometricShape, String unknownProperty) throws CustomException {
        String shapeName = geometricShape.getShapeName();
        if (shapeName.equals("rectangular parallelepiped")) {
            return new RectangularParallelepipedSolver(geometricShape, unknownProperty);
        }
        else if (shapeName.equals("cube")) {
            return new CubeSolver(geometricShape, unknownProperty);
        }
        else if (shapeName.equals("sphere")) {
            return new SphereSolver(geometricShape, unknownProperty);
        }
        else if (shapeName.equals("regular square pyramid")) {
            return new RegularSquarePyramidSolver(geometricShape, unknownProperty);
        }
        else if (shapeName.equals("regular tetrahedron")) {
            return new RegularTetrahedronSolver(geometricShape, unknownProperty);
        }
        else if (shapeName.equals("cylinder")) {
            return new CylinderSolver(geometricShape, unknownProperty);
        }
        throw new CustomException("Unknown geometric shape!");
    }
}
