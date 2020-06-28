package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricShape;
import com.backend.back.utils.NumberFormatter;
import lombok.AllArgsConstructor;

import java.util.*;

public class SphereSolver extends Solver {
    public SphereSolver(GeometricShape geometricShape, String requiredInfo) {
        super(geometricShape, requiredInfo);
    }

    @Override
    public Map<String, List<Step>> getTheory() {
        Map<String, List<Step>> theory = new HashMap<>();
        theory.put("diameter", new ArrayList<>());
        theory.get("diameter").add(new Step1(super.geometricShape.getDetails()));
        theory.put("radius", new ArrayList<>());
        theory.get("radius").add(new Step2(super.geometricShape.getDetails()));
        theory.get("radius").add(new Step4(super.geometricShape.getDetails()));
        theory.get("radius").add(new Step6(super.geometricShape.getDetails()));
        theory.put("surface area", new ArrayList<>());
        theory.get("surface area").add(new Step3(super.geometricShape.getDetails()));
        theory.put("volume", new ArrayList<>());
        theory.get("volume").add(new Step5(super.geometricShape.getDetails()));
        return theory;
    }

    @AllArgsConstructor
    private class Step1 implements Step {
        Map<String, Float> d;

        // d = 2 * r
        @Override
        public void executeStep() {
            Float diameter = 2 * d.get("radius");
            d.put("diameter", diameter);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("radius");
        }

        @Override
        public String getUnknownProperty() {
            return "diameter";
        }

        @Override
        public List<String> getFormulas() {
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 2 * radius";
            String calculation = getUnknownProperty() + " = 2 * " + radius + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step2 implements Step {
        Map<String, Float> d;

        // r = d / 2
        @Override
        public void executeStep() {
            Float radius = d.get("diameter") / 2;
            d.put("radius", radius);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("diameter");
        }

        @Override
        public String getUnknownProperty() {
            return "radius";
        }

        @Override
        public List<String> getFormulas() {
            Number diameter = NumberFormatter.getNumber(d.get("diameter"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = diameter / 2";
            String calculation = getUnknownProperty() + " = " + diameter + " cm / 2";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step3 implements Step {
        Map<String, Float> d;

        //S = 4 * pi * r ^ 2
        @Override
        public void executeStep() {
            Float surfaceArea = (float)(4 * Math.PI * d.get("radius") * d.get("radius"));
            d.put("surface area", surfaceArea);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("radius");
        }

        @Override
        public String getUnknownProperty() {
            return "surface area";
        }

        @Override
        public List<String> getFormulas() {
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 4 * π * radius ^ 2";
            String calculation = getUnknownProperty() + " = 4 * π * (" + radius + " cm)^2";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step4 implements Step {
        Map<String, Float> d;

        // r = 1/2 * sqrt(S / pi)
        @Override
        public void executeStep() {
            Float radius = (float)(0.5 * Math.sqrt(d.get("surface area") / Math.PI));
            d.put("radius", radius);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("surface area");
        }

        @Override
        public String getUnknownProperty() {
            return "radius";
        }

        @Override
        public List<String> getFormulas() {
            Number surfaceArea = NumberFormatter.getNumber(d.get("surface area"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 1/2 * sqrt(surface area/π)";
            String calculation = getUnknownProperty() + " = 1/2 * sqrt(" + surfaceArea + " cm^2/π)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step5 implements Step {
        Map<String, Float> d;

        // V = 4/3 * pi * r^3
        @Override
        public void executeStep() {
            Float volume = (float)(4.0/3.0 * Math.PI * d.get("radius") * d.get("radius") * d.get("radius"));
            d.put("volume", volume);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("radius");
        }

        @Override
        public String getUnknownProperty() {
            return "volume";
        }

        @Override
        public List<String> getFormulas() {
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 4/3 * π * radius ^ 3";
            String calculation = getUnknownProperty() + " = 4/3 * π * (" + radius + " cm)^3";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^3";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step6 implements Step {
        Map<String, Float> d;

        // r = cbrt(3/4 * volume / pi)
        @Override
        public void executeStep() {
            Float radius = (float)(Math.cbrt(3.0/4.0 * d.get("volume")/Math.PI));
            d.put("radius", radius);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("volume");
        }

        @Override
        public String getUnknownProperty() {
            return "radius";
        }

        @Override
        public List<String> getFormulas() {
            Number volume = NumberFormatter.getNumber(d.get("volume"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = cbrt(3/4 * surface area/π)";
            String calculation = getUnknownProperty() + " = sqrt(3/4 * " + volume + " cm^3/π)";
            String helper = "cbrt(n) = cube root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }
}
