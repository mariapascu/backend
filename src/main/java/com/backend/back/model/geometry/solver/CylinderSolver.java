package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricShape;
import com.backend.back.utils.NumberFormatter;
import lombok.AllArgsConstructor;

import java.util.*;

public class CylinderSolver extends Solver {
    public CylinderSolver(GeometricShape geometricShape, String requiredInfo) {
        super(geometricShape, requiredInfo);
    }

    @Override
    public Map<String, List<Step>> getTheory() {
        Map<String, List<Step>> theory = new HashMap<>();
        theory.put("base surface", new ArrayList<>());
        theory.get("base surface").add(new Step1(super.geometricShape.getDetails()));
        theory.put("radius", new ArrayList<>());
        theory.get("radius").add(new Step2(super.geometricShape.getDetails()));
        theory.get("radius").add(new Step5(super.geometricShape.getDetails()));
        theory.get("radius").add(new Step8(super.geometricShape.getDetails()));
        theory.put("total surface", new ArrayList<>());
        theory.get("total surface").add(new Step3(super.geometricShape.getDetails()));
        theory.put("volume", new ArrayList<>());
        theory.get("volume").add(new Step4(super.geometricShape.getDetails()));
        theory.put("height", new ArrayList<>());
        theory.get("height").add(new Step6(super.geometricShape.getDetails()));
        theory.get("height").add(new Step9(super.geometricShape.getDetails()));
        theory.put("lateral surface", new ArrayList<>());
        theory.get("lateral surface").add(new Step7(super.geometricShape.getDetails()));
        return theory;
    }

    @AllArgsConstructor
    private class Step1 implements Step {
        Map<String, Float> d;

        //bs = pi * r^2
        @Override
        public void executeStep() {
            Float baseSurface = (float)Math.PI * d.get("radius") * d.get("radius");
            d.put("base surface", baseSurface);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("radius");
        }

        @Override
        public String getUnknownProperty() {
            return "base surface";
        }

        @Override
        public List<String> getFormulas() {
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = π * radius ^ 2";
            String calculation = getUnknownProperty() + " = π * (" + radius + " cm)^2";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step2 implements Step {
        Map<String, Float> d;

        // r = sqrt(bs / pi)
        @Override
        public void executeStep() {
            Float radius = (float)(Math.sqrt(d.get("base surface")) / Math.PI);
            d.put("radius", radius);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("base surface");
        }

        @Override
        public String getUnknownProperty() {
            return "radius";
        }

        @Override
        public List<String> getFormulas() {
            Number baseSurface = NumberFormatter.getNumber(d.get("base surface"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(base surface/π)";
            String calculation = getUnknownProperty() + " = sqrt(" + baseSurface + "c m^2/π)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step3 implements Step {
        Map<String, Float> d;

        //ts = 2 * pi * r (r + h)
        @Override
        public void executeStep() {
            Float totalSurface = (float)(2.0 * Math.PI * d.get("radius") * (d.get("radius") + d.get("height")));
            d.put("total surface", totalSurface);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("radius", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "total surface";
        }

        @Override
        public List<String> getFormulas() {
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number height = NumberFormatter.getNumber(d.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 2 * π * radius * (radius + height)";
            String calculation = getUnknownProperty() + " = 2 * π * " + radius + " cm * (" + radius + " cm + " + height + " cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step4 implements Step {
        Map<String, Float> d;

        // v = pi * r ^ 2 * h
        @Override
        public void executeStep() {
            Float volume = (float)(Math.PI * d.get("radius") * d.get("radius") * d.get("height"));
            d.put("volume", volume);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("radius", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "volume";
        }

        @Override
        public List<String> getFormulas() {
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number height = NumberFormatter.getNumber(d.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = π * radius ^ 2 * height";
            String calculation = getUnknownProperty() + " =  π * (" + radius + " cm)^2 * " + height + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^3";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step5 implements Step {
        Map<String, Float> d;

        // r = sqrt(V / (pi * h))
        @Override
        public void executeStep() {
            Float radius = (float)(Math.sqrt(d.get("volume") / (Math.PI * d.get("height"))));
            d.put("radius", radius);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("volume", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "radius";
        }

        @Override
        public List<String> getFormulas() {
            Number volume = NumberFormatter.getNumber(d.get("volume"));
            Number height = NumberFormatter.getNumber(d.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(volume / (π * height))";
            String calculation = getUnknownProperty() + " = sqrt(" + volume + " cm^3/ (π * (" + height + " cm)))";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step6 implements Step {
        Map<String, Float> d;

        //h = V / pi * r ^ 2
        @Override
        public void executeStep() {
            Float height = (float)(d.get("volume") / (Math.PI * d.get("radius") * d.get("radius")));
            d.put("height", height);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("volume", "radius");
        }

        @Override
        public String getUnknownProperty() {
            return "height";
        }

        @Override
        public List<String> getFormulas() {
            Number volume = NumberFormatter.getNumber(d.get("volume"));
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = volume / (π * radius^2))";
            String calculation = getUnknownProperty() + " = " + volume + " cm^3/ (π * (" + radius + " cm)^2)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step7 implements Step {
        Map<String, Float> d;

        //lS = 2 * pi * r * h
        @Override
        public void executeStep() {
            Float lateralSurface = (float)(2.0 * Math.PI * d.get("radius") * d.get("height"));
            d.put("lateral surface", lateralSurface);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("radius", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "lateral surface";
        }

        @Override
        public List<String> getFormulas() {
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number height = NumberFormatter.getNumber(d.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 2 * π * radius * height";
            String calculation = getUnknownProperty() + " = 2*  π * (" + radius + " cm) * (" + height + " cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step8 implements Step {
        Map<String, Float> d;

        // r = ls / (2 * pi * h)
        @Override
        public void executeStep() {
            Float radius = (float)(d.get("lateral surface") / (2.0 * Math.PI * d.get("height")));
            d.put("radius", radius);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("lateral surface", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "radius";
        }

        @Override
        public List<String> getFormulas() {
            Number lateralSurface = NumberFormatter.getNumber(d.get("lateral surface"));
            Number height = NumberFormatter.getNumber(d.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = lateral surface / (2 * π * radius))";
            String calculation = getUnknownProperty() + " = " + lateralSurface + " cm^2/ (2 * π * (" + height + " cm))";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step9 implements Step {
        Map<String, Float> d;

        // h = ls / (2 * pi * r)
        @Override
        public void executeStep() {
            Float height = (float)(d.get("lateral surface") / (2.0 * Math.PI * d.get("radius")));
            d.put("height", height);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("lateral surface", "radius");
        }

        @Override
        public String getUnknownProperty() {
            return "height";
        }

        @Override
        public List<String> getFormulas() {
            Number lateralSurface = NumberFormatter.getNumber(d.get("lateral surface"));
            Number radius = NumberFormatter.getNumber(d.get("radius"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = lateral surface / (2 * π * radius))";
            String calculation = getUnknownProperty() + " = " + lateralSurface + " cm^2/ (2 * π * (" + radius + " cm))";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }
}
