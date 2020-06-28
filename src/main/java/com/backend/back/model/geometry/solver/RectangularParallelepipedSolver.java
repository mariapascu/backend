package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricShape;
import com.backend.back.utils.NumberFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
public class RectangularParallelepipedSolver extends Solver{
    public RectangularParallelepipedSolver(GeometricShape rectangularParallelepiped, String requiredInfo) {
        super(rectangularParallelepiped, requiredInfo);
    }

    public Map<String, List<Step>> getTheory() {
        Map<String, List<Step>> theory = new HashMap<>();
        theory.put("total surface", new ArrayList<>());
        theory.get("total surface").add(new Step1(super.geometricShape.getDetails()));
        theory.put("base surface", new ArrayList<>());
        theory.get("base surface").add(new Step2(super.geometricShape.getDetails()));
        theory.put("lateral surface", new ArrayList<>());
        theory.get("lateral surface").add(new Step3(super.geometricShape.getDetails()));
        theory.put("volume", new ArrayList<>());
        theory.get("volume").add(new Step4(super.geometricShape.getDetails()));
        theory.put("base perimeter", new ArrayList<>());
        theory.get("base perimeter").add(new Step5(super.geometricShape.getDetails()));
        theory.put("length", new ArrayList<>());
        theory.get("length").add(new Step7(super.geometricShape.getDetails()));
        theory.get("length").add(new Step8(super.geometricShape.getDetails()));
        theory.get("length").add(new Step11(super.geometricShape.getDetails()));
        theory.put("width", new ArrayList<>());
        theory.get("width").add(new Step6(super.geometricShape.getDetails()));
        theory.get("width").add(new Step9(super.geometricShape.getDetails()));
        theory.get("width").add(new Step12(super.geometricShape.getDetails()));
        theory.put("height", new ArrayList<>());
        theory.get("height").add(new Step10(super.geometricShape.getDetails()));
        return theory;
    }

    @AllArgsConstructor
    private class Step1 implements Step {
        Map<String, Float> p;

        // totalSurface = 2(l * w + l * h + w * h)
        public void executeStep() {
            Float totalSurface = 2 * (p.get("length") * p.get("width") + p.get("length") * p.get("height") + p.get("width") * p.get("height"));
            p.put("total surface", totalSurface);
        }

        @Override
        public List<String> getFormulas() {
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number height = NumberFormatter.getNumber(p.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 2 * (length * width + length * height + width * height)";
            String calculation = getUnknownProperty() + " = 2 * (" + length + " cm * "+ width + " cm + "
                    + length + " cm * " + height + " cm + " + width + " cm * " + height + " cm)";

            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("length", "width", "length");
        }

        @Override
        public String getUnknownProperty() {
            return "total surface";
        }
    }

    @AllArgsConstructor
    private class Step2 implements Step {
        Map<String, Float> p;

        // baseSurface = l * w
        public void executeStep() {
            Float baseSurface = p.get("length") * p.get("width");
            p.put("base surface", baseSurface);
        }

        @Override
        public List<String> getFormulas() {
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = length * width";
            String calculation = getUnknownProperty() + " = " + length + " cm * " + width + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("length", "width");
        }

        @Override
        public String getUnknownProperty() {
            return "base surface";
        }
    }

    @AllArgsConstructor
    private class Step3 implements Step {
        Map<String, Float> p;

        // lateralSurface = 2(l * w + w * h)
        public void executeStep() {
            Float lateralSurface = 2 * (p.get("length") * p.get("width") + p.get("width") * p.get("height"));
            p.put("lateral surface", lateralSurface);
        }

        @Override
        public List<String> getFormulas() {
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number height = NumberFormatter.getNumber(p.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 2 * (length * width + width * height)";
            String calculation = getUnknownProperty() + " = " + " 2 * (" + length + " cm * " + width
                    + " cm + " + width + " cm * " + height +" cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^2";
            return Arrays.asList(formula, calculation, result);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("length", "width", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "lateral surface";
        }

        @Override
        public String toString() {
            return "lateralSurface = 2(l * w + w * h)";
        }
    }

    @AllArgsConstructor
    private class Step4 implements Step {
        Map<String, Float> p;

        // volume = l * w * h
        public void executeStep() {
            Float volume = p.get("length") * p.get("width") * p.get("height");
            p.put("volume", volume);
        }

        @Override
        public List<String> getFormulas() {
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number height = NumberFormatter.getNumber(p.get("height"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = length * width * height";
            String calculation = getUnknownProperty() + " = " + length + " cm * " + width + " cm * " + height + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm^3";
            return Arrays.asList(formula, calculation, result);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("length", "width", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "volume";
        }

        @Override
        public String toString() {
            return "volume = l * w * h";
        }
    }

    @AllArgsConstructor
    private class Step5 implements Step {
        Map<String, Float> p;

        // basePerimeter = 2(l + w)
        public void executeStep() {
            Float basePerimeter = 2 * (p.get("length") + p.get("width"));
            p.put("base perimeter", basePerimeter);
        }

        @Override
        public List<String> getFormulas() {
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = 2 * (length + width)";
            String calculation = getUnknownProperty() + " = 2 * (" + length +  " cm + " + width + " cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("length", "width");
        }

        @Override
        public String getUnknownProperty() {
            return "base perimeter";
        }
    }

    @AllArgsConstructor
    private class Step6 implements Step {
        Map<String, Float> p;

        // w = bS / L
        @Override
        public void executeStep() {
            Float width = p.get("base surface") / p.get("length");
            p.put("width", width);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("base surface", "length");
        }

        @Override
        public String getUnknownProperty() {
            return "width";
        }

        @Override
        public List<String> getFormulas() {
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number baseSurface = NumberFormatter.getNumber(p.get("base surface"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = base surface / length";
            String calculation = getUnknownProperty() + " = " + baseSurface + " cm^2/" + length + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step7 implements Step {
        Map<String, Float> p;

        // L = bS / w
        @Override
        public void executeStep() {
            Float length = p.get("base surface") / p.get("width");
            p.put("length", length);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("base surface", "width");
        }

        @Override
        public String getUnknownProperty() {
            return "length";
        }

        @Override
        public List<String> getFormulas() {
            Number baseSurface = NumberFormatter.getNumber(p.get("base surface"));
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = base surface / width";
            String calculation = getUnknownProperty() + " = " + baseSurface + " cm^2/" + width + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step8 implements Step {
        Map<String, Float> p;

        // L = V / (w * h)
        @Override
        public void executeStep() {
            Float length = p.get("volume") / (p.get("width") * p.get("height"));
            p.put("length", length);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("volume", "width", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "length";
        }

        @Override
        public List<String> getFormulas() {
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number height = NumberFormatter.getNumber(p.get("height"));
            Number volume = NumberFormatter.getNumber(p.get("volume"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = volume / (width * height)";
            String calculation = getUnknownProperty() + " = " + volume + " cm^3/(" + width + " cm * " + height + " cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step9 implements Step {
        Map<String, Float> p;

        // l = V / (L * h)
        @Override
        public void executeStep() {
            Float width = p.get("volume") / (p.get("length") * p.get("height"));
            p.put("width", width);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("volume", "length", "height");
        }

        @Override
        public String getUnknownProperty() {
            return "width";
        }

        @Override
        public List<String> getFormulas() {
            Number height = NumberFormatter.getNumber(p.get("height"));
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            Number volume = NumberFormatter.getNumber(p.get("volume"));
            String formula = getUnknownProperty() + " = volume / (width * height)";
            String calculation = getUnknownProperty() + " = " + volume + " cm^3/(" + length + " cm * " + height + " cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step10 implements Step {
        Map<String, Float> p;

        // h = V / (L * w)
        @Override
        public void executeStep() {
            Float height = p.get("volume") / (p.get("length") * p.get("width"));
            p.put("height", height);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("volume", "length", "width");
        }

        @Override
        public String getUnknownProperty() {
            return "height";
        }

        @Override
        public List<String> getFormulas() {
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number volume = NumberFormatter.getNumber(p.get("volume"));
            String formula = getUnknownProperty() + " = volume / (width * height)";
            String calculation = getUnknownProperty() + " = " + volume + " cm^3/(" + length + " cm * " + width + " cm)";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step11 implements Step {
        Map<String, Float> p;

        // L = P / 2 - w
        @Override
        public void executeStep() {
            Float length = p.get("base perimeter") / 2 - p.get("width");
            p.put("length", length);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("base perimeter", "width");
        }

        @Override
        public String getUnknownProperty() {
            return "length";
        }

        @Override
        public List<String> getFormulas() {
            Number width = NumberFormatter.getNumber(p.get("width"));
            Number basePerimeter = NumberFormatter.getNumber(p.get("base perimeter"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = base perimeter / 2 - width";
            String calculation = getUnknownProperty() + " = " + basePerimeter + " cm/ 2 - " + width + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }

    @AllArgsConstructor
    private class Step12 implements Step {
        Map<String, Float> p;

        // w = P / 2 - L
        @Override
        public void executeStep() {
            Float width = p.get("base perimeter") / 2 - p.get("length");
            p.put("width", width);
        }

        @Override
        public List<String> getKnownProperties() {
            return Arrays.asList("base perimeter", "length");
        }

        @Override
        public String getUnknownProperty() {
            return "width";
        }

        @Override
        public List<String> getFormulas() {
            Number length = NumberFormatter.getNumber(p.get("length"));
            Number basePerimeter = NumberFormatter.getNumber(p.get("base perimeter"));
            Number unknownProperty = NumberFormatter.getNumber(p.get(getUnknownProperty()));
            String formula = getUnknownProperty() + " = base perimeter / 2 - width";
            String calculation = getUnknownProperty() + " = " + basePerimeter + " cm/ 2 - " + length + " cm";
            String result = getUnknownProperty() + " = " + unknownProperty + " cm";
            return Arrays.asList(formula, calculation, result);
        }
    }
}

