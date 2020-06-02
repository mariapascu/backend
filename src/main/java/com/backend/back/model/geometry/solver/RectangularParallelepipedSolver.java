package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.GeometricFigure;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
public class RectangularParallelepipedSolver extends Solver{
    public RectangularParallelepipedSolver(GeometricFigure rectangularParallelepiped, String requiredInfo) {
        super(rectangularParallelepiped, requiredInfo);
    }

    public List<String> getKnown() {
        List<String> known = new ArrayList<>();
        known.addAll(super.geometricFigure.getDetails().keySet());

        return known;
    }


    public Map<String, List<Step>> getTheory() {
        Map<String, List<Step>> theory = new HashMap<>();
        theory.put("total surface", new ArrayList<>());
        theory.get("total surface").add(new Step1(super.geometricFigure));
        theory.put("base surface", new ArrayList<>());
        theory.get("base surface").add(new Step2(super.geometricFigure));
        theory.put("lateral surface", new ArrayList<>());
        theory.get("lateral surface").add(new Step3(super.geometricFigure));
        theory.put("volume", new ArrayList<>());
        theory.get("volume").add(new Step4(super.geometricFigure));
        theory.put("base perimeter", new ArrayList<>());
        theory.get("base perimeter").add(new Step5(super.geometricFigure));
        theory.put("width", new ArrayList<>());
        theory.get("width").add(new Step9(super.geometricFigure));
        return theory;
    }

    @AllArgsConstructor
    private class Step1 implements Step {
        GeometricFigure p;

        // totalSurface = 2(l * w + l * h + w * h)
        public void executeStep() {
            var m = p.getDetails();
            Float totalSurface = 2 * (m.get("length") * m.get("width") + m.get("length") * m.get("height") + m.get("width") * m.get("height"));
            m.put("total surface", totalSurface);
        }

        @Override
        public List<String> getFormulas() {
            String formula = getUnknownProperty() + " = 2 * (length * width + length * height + width * height)";
            String calculation = getUnknownProperty() + " = 2 * (" + p.getDetails().get("length") + " * "+ p.getDetails().get("width") + " + "
                    + p.getDetails().get("length") + " * " + p.getDetails().get("height") + " + " + p.getDetails().get("width") + " * " + p.getDetails().get("height") + ")";
            String result = getUnknownProperty() + " = " + p.getDetails().get(getUnknownProperty());
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
        GeometricFigure p;

        // baseSurface = l * w
        public void executeStep() {
            var m = p.getDetails();
            Float baseSurface = m.get("length") * m.get("width");
            m.put("base surface", baseSurface);
        }

        @Override
        public List<String> getFormulas() {
            String formula = getUnknownProperty() + " = length * width";
            String calculation = getUnknownProperty() + " = " + p.getDetails().get("length") + " * " + p.getDetails().get("width");
            String result = getUnknownProperty() + " = " + p.getDetails().get(getUnknownProperty());
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
        GeometricFigure p;

        // lateralSurface = 2(l * w + w * h)
        public void executeStep() {
            var m = p.getDetails();
            Float lateralSurface = 2 * (m.get("length") * m.get("width") + m.get("width") * m.get("height"));
            m.put("lateral surface", lateralSurface);
        }

        @Override
        public List<String> getFormulas() {
            String formula = getUnknownProperty() + " = 2 * (length * width + width * height)";
            String calculation = getUnknownProperty() + " = " + " 2 * (" + p.getDetails().get("length") + " * " + p.getDetails().get("width")
                    + " + " +  p.getDetails().get("width") + " * " + p.getDetails().get("height") +")";
            String result = getUnknownProperty() + " = " + p.getDetails().get(getUnknownProperty());
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
        GeometricFigure p;

        // volume = l * w * h
        public void executeStep() {
            var m = p.getDetails();
            Float volume = m.get("length") * m.get("width") * m.get("height");
            m.put("volume", volume);
        }

        @Override
        public List<String> getFormulas() {
            String formula = getUnknownProperty() + " = length * width * height";
            String calculation = getUnknownProperty() + " = " + p.getDetails().get("length") + " * " + p.getDetails().get("width") + " * " + p.getDetails().get("height");
            String result = getUnknownProperty() + " = " + p.getDetails().get(getUnknownProperty());
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
        GeometricFigure p;

        // basePerimeter = 2(l + w)
        public void executeStep() {
            var m = p.getDetails();
            Float basePerimeter = 2 * (m.get("length") + m.get("width"));
            m.put("base perimeter", basePerimeter);
        }

        @Override
        public List<String> getFormulas() {
            String formula = getUnknownProperty() + " = 2 * (length + width)";
            String calculation = getUnknownProperty() + " = 2 * (" + p.getDetails().get("length") +  " + " + p.getDetails().get("width") + ")";
            String result = getUnknownProperty() + " = " + p.getDetails().get(getUnknownProperty());
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

//    @AllArgsConstructor
//    private class Step6 implements Step {
//        RectangularParallelepiped p;
//        // height = (tS - 2 * l * w)/(2 * (L + l))
//        public void executeStep() {
//            Float lateralSurface = 2 * (p.getLength() * p.getWidth() + p.getWidth() * p.getHeight());
//            p.setLateralSurface(lateralSurface);
//        }
//    }

    @AllArgsConstructor
    private class Step9 implements Step {
        GeometricFigure p;

        // w = bS / l
        public void executeStep() {
            var m = p.getDetails();
            Float width = m.get("base surface") / m.get("length");
            m.put("width", width);
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
            String formula = getUnknownProperty() + " = base surface / length";
            String calculation = getUnknownProperty() + " = " + p.getDetails().get("base surface") + " / " + p.getDetails().get("length");
            String result = getUnknownProperty() + " = " + p.getDetails().get(getUnknownProperty());
            return Arrays.asList(formula, calculation, result);
        }

        @Override
        public String toString() {
            String s = getUnknownProperty() + " = " + getKnownProperties().get(0) + " / " + getKnownProperties().get(1) + ";" +
                    getUnknownProperty() + " = " + p.getDetails().get(getKnownProperties().get(0)) + " / " + p.getDetails().get(getKnownProperties().get(1)) + "\n";
            return s;
            //return "w = bS / l";
        }
    }
}

