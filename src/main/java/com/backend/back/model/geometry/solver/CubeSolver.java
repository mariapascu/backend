package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricShape;
import com.backend.back.utils.NumberFormatter;
import lombok.AllArgsConstructor;

import java.util.*;

public class CubeSolver extends Solver {
    public CubeSolver(GeometricShape cube, String requiredInfo) {
        super(cube, requiredInfo);
    }

    @Override
    public Map<String, List<Step>> getTheory() {
        Map<String, List<Step>> theory = new HashMap<>();
        theory.put("edge", new ArrayList<>());
        theory.get("edge").add(new Step2(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step4(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step6(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step8(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step10(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step12(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step14(super.geometricShape.getDetails()));
        theory.put("lateral surface", new ArrayList<>());
        theory.get("lateral surface").add(new Step1(super.geometricShape.getDetails()));
        theory.put("total surface", new ArrayList<>());
        theory.get("total surface").add(new Step3(super.geometricShape.getDetails()));
        theory.put("volume", new ArrayList<>());
        theory.get("volume").add(new Step5(super.geometricShape.getDetails()));
        theory.put("face diagonal", new ArrayList<>());
        theory.get("face diagonal").add(new Step7(super.geometricShape.getDetails()));
        theory.put("cube diagonal", new ArrayList<>());
        theory.get("cube diagonal").add(new Step9(super.geometricShape.getDetails()));
        theory.put("base perimeter", new ArrayList<>());
        theory.get("base perimeter").add(new Step11(super.geometricShape.getDetails()));
        theory.put("base surface", new ArrayList<>());
        theory.get("base surface").add(new Step13(super.geometricShape.getDetails()));
        return theory;
    }

    @AllArgsConstructor
    private class Step1 implements Step {
        Map<String, Float> d;

        //Al = 4 * l^2
        @Override
        public void executeStep() {
            Float lateralSurface = 4 * (d.get("edge") * d.get("edge"));
            d.put("lateral surface", lateralSurface);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "lateral surface";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 4 * edge^2";
            String calculation = getUnknownProperty() + " = 4 * (" + edge + " cm)^2";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step2 implements Step {
        Map<String, Float> d;

        // l = sqrt(Al) / 2
        @Override
        public void executeStep() {
            Float edge = (float) (Math.sqrt(d.get("lateral surface")) / 2);
            d.put("edge", edge);

        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("lateral surface");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number lateralSurface = NumberFormatter.getNumber(d.get("lateral surface"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(lateral surface) / 2";
            String calculation = getUnknownProperty() + " = sqrt(" + lateralSurface + " cm^2)/2";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step3 implements Step {
        Map<String, Float> d;

        //total surface = 6 * l ^ 2;
        @Override
        public void executeStep() {
            Float totalSurface = 6 * (d.get("edge") * d.get("edge"));
            d.put("total surface", totalSurface);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "total surface";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 6 * edge^2";
            String calculation = getUnknownProperty() + " = 6 * (" + edge + " cm)^2";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step4 implements Step {
        Map<String, Float> d;

        // l = sqrt(At / 6);
        @Override
        public void executeStep() {
            Float edge = (float)Math.sqrt(d.get("total surface") / 6);
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("total surface");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number totalSurface = NumberFormatter.getNumber(d.get("total surface"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(lateral surface) / 6";
            String calculation = getUnknownProperty() + " = sqrt(" + totalSurface + " cm^2/6)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step5 implements Step {
        Map<String, Float> d;

        // V = l ^ 3;
        @Override
        public void executeStep() {
            Float volume = d.get("edge") * d.get("edge") * d.get("edge");
            d.put("volume", volume);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "volume";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = edge^3";
            String calculation = getUnknownProperty() + " = (" + edge + " cm)^3";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^3";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step6 implements Step {
        Map<String, Float> d;

        // l  = (sqrt(3, V))
        @Override
        public void executeStep() {
            Float edge = (float)Math.cbrt(d.get("volume"));
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("volume");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number volume = NumberFormatter.getNumber(d.get("volume"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = cbrt(volume)";
            String calculation = getUnknownProperty() + " = cbrt(" + volume + " cm^3)";
            String helper = "cbrt(n) = cube root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step7 implements Step {
        Map<String, Float> d;

        //fd = l * sqrt(2)
        @Override
        public void executeStep() {
            Float faceDiagonal = (float)(d.get("edge") * Math.sqrt(2));
            d.put("face diagonal", faceDiagonal);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "face diagonal";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = edge * sqrt(2)";
            String calculation = getUnknownProperty() + " = " + edge + " cm * sqrt(2)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step8 implements Step {
        Map<String, Float> d;

        // l = fd / sqrt(2)
        @Override
        public void executeStep() {
            Float edge = (float)(d.get("face diagonal") / Math.sqrt(2));
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("face diagonal");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number faceDiagonal = NumberFormatter.getNumber(d.get("face diagonal"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = face diagonal / sqrt(2)";
            String calculation = getUnknownProperty() + " = " + faceDiagonal + " cm/sqrt(2)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step9 implements Step {
        Map<String, Float> d;

        //cd = l * sqrt(3)
        @Override
        public void executeStep() {
            Float cubeDiagonal = (float)(d.get("edge") * Math.sqrt(3));
            d.put("cube diagonal", cubeDiagonal);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "cube diagonal";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = edge * sqrt(3)";
            String calculation = getUnknownProperty() + " = " + edge + " cm * sqrt(3)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step10 implements Step {
        Map<String, Float> d;

        // l = cd / sqrt(3)
        @Override
        public void executeStep() {
            Float edge = (float)(d.get("cube diagonal") / Math.sqrt(3));
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("cube diagonal");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number cubeDiagonal = NumberFormatter.getNumber(d.get("cube diagonal"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = face diagonal / sqrt(3)";
            String calculation = getUnknownProperty() + " = " + cubeDiagonal + " cm/sqrt(3)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step11 implements Step {
        Map<String, Float> d;

        // bP = 4 * l
        @Override
        public void executeStep() {
            Float basePerimeter = 4 * d.get("edge");
            d.put("base perimeter", basePerimeter);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "base perimeter";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 4 * edge";
            String calculation = getUnknownProperty() + " = 4 * (" + edge + " cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step12 implements Step {
        Map<String, Float> d;

        // l = bP / 4
        @Override
        public void executeStep() {
            Float edge = d.get("base perimeter") / 4;
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("base perimeter");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number basePerimeter = NumberFormatter.getNumber(d.get("base perimeter"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = base perimeter / 4";
            String calculation = getUnknownProperty() + " = " + basePerimeter + " cm/4";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step13 implements Step {
        Map<String, Float> d;

        // bS = l ^ 2;
        @Override
        public void executeStep() {
            Float baseSurface = d.get("edge") * d.get("edge");
            d.put("base surface", baseSurface);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "base surface";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = edge ^ 2";
            String calculation = getUnknownProperty() + " = (" + edge + " cm)^2";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step14 implements Step {
        Map<String, Float> d;

        // l = sqrt(bS)
        @Override
        public void executeStep() {
            Float edge = (float)Math.sqrt(d.get("base surface"));
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("base surface");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number baseSurface = NumberFormatter.getNumber(d.get("base surface"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(base surface)";
            String calculation = getUnknownProperty() + " = sqrt(" + baseSurface + " cm^2)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }
}
