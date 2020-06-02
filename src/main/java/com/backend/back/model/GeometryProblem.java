package com.backend.back.model;

import com.backend.back.model.geometry.GeometricFigure;
import com.backend.back.model.geometry.solver.RectangularParallelepipedSolver;
import com.backend.back.model.geometry.solver.Solver;
import com.backend.back.model.geometry.solver.Step;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GeometryProblems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeometryProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "geometry_problem_id")
    private Long geometryProblemId;

    @OneToOne(fetch = FetchType.LAZY)
    private GeometricFigure geometricFigure;

    @Column(name = "unknown_property")
    private String unknownProperty;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

    public Pair<Float, List<Step>> getSolution() {
        Solver solver = new RectangularParallelepipedSolver(geometricFigure, unknownProperty);
        return solver.solve();
    }


}
