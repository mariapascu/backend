package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricShape;
import com.backend.back.utils.NumberFormatter;
import lombok.AllArgsConstructor;

import java.util.*;

public class RegularTetrahedronSolver extends Solver {
    public RegularTetrahedronSolver(GeometricShape geometricShape, String requiredInfo) {
        super(geometricShape, requiredInfo);
    }

    @Override
    public Map<String, List<Step>> getTheory() {
        Map<String, List<Step>> theory = new HashMap<>();
        theory.put("volume", new ArrayList<>());
        theory.get("volume").add(new Step1(super.geometricShape.getDetails()));
        theory.put("height", new ArrayList<>());
        theory.get("height").add(new Step3(super.geometricShape.getDetails()));
        theory.put("total surface", new ArrayList<>());
        theory.get("total surface").add(new Step5(super.geometricShape.getDetails()));
        theory.put("face surface", new ArrayList<>());
        theory.get("face surface").add(new Step7(super.geometricShape.getDetails()));
        theory.put("edge", new ArrayList<>());
        theory.get("edge").add(new Step2(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step4(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step6(super.geometricShape.getDetails()));
        theory.get("edge").add(new Step8(super.geometricShape.getDetails()));
        return theory;
    }

    @AllArgsConstructor
    private class Step1 implements Step {
        Map<String, Float> d;

        // V = e^3 / (6 * sqrt(2))
        @Override
        public void executeStep() {
            Float volume = (float)((d.get("edge") * d.get("edge") * d.get("edge")) / 6.0 * Math.sqrt(2));
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
            String formula = getUnknownProperty() + " = edge^3 / (6 * sqrt(2))";
            String calculation = getUnknownProperty() + " = (" + edge + " cm)^3 / (6 * sqrt(2))";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^3";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step2 implements Step {
        Map<String, Float> d;

        // e = cbrt(V * 6 * sqrt(2))
        @Override
        public void executeStep() {
            Float edge = (float)(Math.cbrt(d.get("volume") * 6.0 * Math.sqrt(2)));
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
            String formula = getUnknownProperty() + " = cbrt(volume * 6 * sqrt(2))";
            String calculation = getUnknownProperty() + " = cbrt((" + volume  + " cm)* 6 * sqrt(2))";
            String helper1 = "sqrt(n) = square root of n";
            String helper2 = "cbrt(n) = cube root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper1, helper2, result);
        }
    }

    @AllArgsConstructor
    private class Step3 implements Step {
        Map<String, Float> d;

        // h = sqrt(2/3) * e
        @Override
        public void executeStep() {
            Float height = (float)(Math.sqrt(2.0/3.0) * d.get("edge"));
            d.put("height", height);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "height";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(2/3) * edge";
            String calculation = getUnknownProperty() + " = sqrt(2/3) * (" + edge + " cm)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step4 implements Step {
        Map<String, Float> d;

        // e = sqrt(3 / 2) * height
        @Override
        public void executeStep() {
            Float edge = (float)(Math.sqrt(3.0/2.0) * d.get("height"));
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("height");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number height = NumberFormatter.getNumber(d.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(3/2) * edge";
            String calculation = getUnknownProperty() + " = sqrt(3/2) * (" + height + " cm)";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step5 implements Step {
        Map<String, Float> d;

        // ts = sqrt(3) * edge
        @Override
        public void executeStep() {
            Float totalSurface = (float)(Math.sqrt(3) * d.get("edge") * d.get("edge"));
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
            String formula = getUnknownProperty() + " = sqrt(3) * edge^2";
            String calculation = getUnknownProperty() + " = sqrt(3) * (" + edge + " cm)^2";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step6 implements Step {
        Map<String, Float> d;

        // e = sqrt(ts/sqrt(3))
        @Override
        public void executeStep() {
            Float edge = (float)(Math.sqrt(d.get("total surface")/Math.sqrt(3)));
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
            String formula = getUnknownProperty() + " = sqrt(total surface / sqrt(3))";
            String calculation = getUnknownProperty() + " = sqrt((" + totalSurface + " cm^2) / sqrt(3))";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step7 implements Step {
        Map<String, Float> d;

        // fS = sqrt(3) / 4 * e^2;
        @Override
        public void executeStep() {
            Float faceSurface = (float)(Math.sqrt(3) / 4 * d.get("edge") * d.get("edge"));
            d.put("face surface", faceSurface);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("edge");
        }

        @Override
        public String getUnknownProperty() {
            return "face surface";
        }

        @Override
        public List<String> getFormulas() {
            Number edge = NumberFormatter.getNumber(d.get("edge"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = sqrt(3) / 4 * edge^2";
            String calculation = getUnknownProperty() + " = sqrt(3) / 4 * (" + edge + " cm)^2";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }

    @AllArgsConstructor
    private class Step8 implements Step {
        Map<String, Float> d;

        // e = 2 * sqrt(fs / sqrt(3))
        @Override
        public void executeStep() {
            Float edge = (float)(2 * Math.sqrt(d.get("face surface") / Math.sqrt(3)));
            d.put("edge", edge);
        }

        @Override
        public List<String> getKnownProperties() {
            return Collections.singletonList("face surface");
        }

        @Override
        public String getUnknownProperty() {
            return "edge";
        }

        @Override
        public List<String> getFormulas() {
            Number faceSurface = NumberFormatter.getNumber(d.get("face surface"));
            Number unknownProperty = NumberFormatter.getNumber(d.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 2 * sqrt(face surface / sqrt(3))";
            String calculation = getUnknownProperty() + " = sqrt((" + faceSurface + " cm^2) / sqrt(3))";
            String helper = "sqrt(n) = square root of n";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, helper, result);
        }
    }
}
