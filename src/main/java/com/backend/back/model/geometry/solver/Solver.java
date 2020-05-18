package com.backend.back.model.geometry.solver;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class Solver<FIGURE> {
    protected FIGURE geometricFigure;
    protected Map<String, List<Pair<List<String>, Step>>> theory = new HashMap<>();
    protected String requiredInfo;

    public Solver(FIGURE geometricFigure, String requiredInfo) {
        this.geometricFigure = geometricFigure;
        this.requiredInfo = requiredInfo;
        theory = getTheory();
    }

    public abstract Map<String, List<Pair<List<String>, Step>>> getTheory();
    public abstract List<String> getKnown();

    public void solve() {
        var sol = findResult(requiredInfo, getKnown(), new ArrayList<>());
        for (var s : sol) {
            System.out.println(s.toString());
        }
    }

    private List<Step> findResult(String unknown, List<String> known, List<String> cantUse) {
        if (known.contains(unknown)) {
            return new ArrayList<>();
        }

        var value = theory.get(unknown);
        for (var pair : value) {
            if (known.containsAll(pair.getKey())) {
                return new ArrayList<>(Arrays.asList(pair.getValue()));
            }
        }

        List<Step> result = null;

        value = theory.get(unknown);
        for (var pair : value) {
            if (cantUse.stream().distinct().filter(pair.getKey()::contains).collect(Collectors.toSet()).size() != 0) {
                continue;
            }
            List<String> knownNew = new ArrayList<>(known);
            boolean error = false;
            List<Step> partialRes = new ArrayList<>();
            for (var knowns : pair.getKey()) {
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
                    result.add(pair.getValue());
                }
            }
        }

        return result;

    }
}
