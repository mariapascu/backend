package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricFigure;
import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class Solver {
    protected GeometricFigure geometricFigure;
    protected Map<String, List<Step>> theory = new HashMap<>();
    protected String requiredInfo;

    public Solver(GeometricFigure geometricFigure, String requiredInfo) {
        this.geometricFigure = geometricFigure;
        this.requiredInfo = requiredInfo;
        theory = getTheory();
    }

    public abstract Map<String, List<Step>> getTheory();
    public abstract List<String> getKnown();

    public Pair<Float, List<Step>> solve() {
        var sol = findResult(requiredInfo, getKnown(), new ArrayList<>());
        if (sol == null) {
            sol = new ArrayList<>();
        }
        for (var s : sol) {
            s.executeStep();
            System.out.println(s.toString());
        }

        return new Pair<>(this.geometricFigure.getDetails().get(requiredInfo), sol);
    }

    private List<Step> findResult(String unknown, List<String> known, List<String> cantUse) {
        if (known.contains(unknown)) {
            return new ArrayList<>();
        }

        var value = theory.get(unknown);
        for (var step : value) {
            if (known.containsAll(step.getKnownProperties())) {
                return new ArrayList<>(Arrays.asList(step));
            }
        }

        List<Step> result = null;

        value = theory.get(unknown);
        for (var step : value) {
            if (cantUse.stream().distinct().filter(step.getKnownProperties()::contains).collect(Collectors.toSet()).size() != 0) {
                continue;
            }
            List<String> knownNew = new ArrayList<>(known);
            boolean error = false;
            List<Step> partialRes = new ArrayList<>();
            for (var knowns : step.getKnownProperties()) {
                List<String> cantUseNew = new ArrayList<>(cantUse);
                cantUseNew.add(unknown);
                var res = findResult(knowns, knownNew, cantUseNew);
                if (res != null) {
                    Collections.reverse(res);
                    partialRes.addAll(res);
                }
                else {
                    error = true;
                    break;
                }
            }
            if (!error) {
                if (result == null || result.size() > partialRes.size()) {
                    result = partialRes;
                    result.add(step);
                }
            }
        }

        return result;

    }
}
