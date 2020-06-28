package com.backend.back.model.geometry.solver;

import com.backend.back.exception.CustomException;
import com.backend.back.model.geometry.GeometricShape;
import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class Solver {
    protected GeometricShape geometricShape;
    protected Map<String, List<Step>> theory = new HashMap<>();
    protected String requiredInfo;

    public Solver(GeometricShape geometricShape, String requiredInfo) {
        this.geometricShape = geometricShape;
        this.requiredInfo = requiredInfo;
        theory = getTheory();
    }

    public abstract Map<String, List<Step>> getTheory();
    public List<String> getKnown() {
        List<String> known = new ArrayList<>();
        known.addAll(geometricShape.getDetails().keySet());

        return known;
    }

    public Pair<Float, List<Step>> solve() throws CustomException {
        var sol = findResult(requiredInfo, getKnown(), new ArrayList<>());
        if (sol == null) {
            throw new CustomException("Can't determine a solution!");
        }
        for (var s : sol) {
            s.executeStep();
        }

        return new Pair<>(this.geometricShape.getDetails().get(requiredInfo), sol);
    }

    private List<Step> findResult(String unknownProperty, List<String> knownProperties, List<String> cantUse) {
        if (knownProperties.contains(unknownProperty)) {
            return new ArrayList<>();
        }

        var steps = theory.get(unknownProperty);
        for (var step : steps) {
            if (knownProperties.containsAll(step.getKnownProperties())) {
                knownProperties.add(unknownProperty);
                return new ArrayList<>(Arrays.asList(step));
            }
        }

        List<Step> result = null;

        for (var step : steps) {
            if (cantUse.stream().distinct().filter(step.getKnownProperties()::contains).collect(Collectors.toSet()).size() != 0) {
                continue;
            }
            List<String> knownPropertiesNew = new ArrayList<>(knownProperties);
            boolean error = false;
            List<Step> partialRes = new ArrayList<>();
            for (var stepKnownProperty : step.getKnownProperties()) {
                List<String> cantUseNew = new ArrayList<>(cantUse);
                cantUseNew.add(unknownProperty);
                var res = findResult(stepKnownProperty, knownPropertiesNew, cantUseNew);
                if (res != null) {
                    knownPropertiesNew.add(stepKnownProperty);
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
