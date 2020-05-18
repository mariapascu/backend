package com.backend.back.model.geometry.solver;

import com.backend.back.model.geometry.RectangularParallelepiped;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
public class RectangularParallelepipedSolver extends Solver<RectangularParallelepiped>{
    public RectangularParallelepipedSolver(RectangularParallelepiped rectangularParallelepiped, String requiredInfo) {
        super(rectangularParallelepiped, requiredInfo);
    }

    public List<String> getKnown() {
        List<String> known = new ArrayList<>();
        known.addAll(super.geometricFigure.getDetails().keySet());

        return known;
    }


    public Map<String, List<Pair<List<String>, Step>>> getTheory() {
        Map<String, List<Pair<List<String>, Step>>> theory = new HashMap<>();
        List<String> known = Arrays.asList("length", "width", "height");
        theory.put("totalSurface", new ArrayList<>());
        theory.get("totalSurface").add(new Pair<>(known, new Step1(super.geometricFigure)));
        known = Arrays.asList("length", "width");
        theory.put("baseSurface", new ArrayList<>());
        theory.get("baseSurface").add(new Pair<>(known, new Step2(super.geometricFigure)));
        known = Arrays.asList("length", "width", "height");
        theory.put("lateralSurface", new ArrayList<>());
        theory.get("lateralSurface").add(new Pair<>(known, new Step3(super.geometricFigure)));
        known = Arrays.asList("length", "width", "height");
        theory.put("volume", new ArrayList<>());
        theory.get("volume").add(new Pair<>(known, new Step4(super.geometricFigure)));
        known = Arrays.asList("length", "width");
        theory.put("basePerimeter", new ArrayList<>());
        theory.get("basePerimeter").add(new Pair<>(known, new Step5(super.geometricFigure)));
        known = Arrays.asList("length", "baseSurface");
        theory.put("width", new ArrayList<>());
        theory.get("width").add(new Pair<>(known, new Step9(super.geometricFigure)));
        return theory;
    }

    @AllArgsConstructor
    private class Step1 implements Step {
        RectangularParallelepiped p;

        // totalSurface = 2(l * w + l * h + w * h)
        public void executeStep() {
            var m = p.getDetails();
            Float totalSurface = 2 * (m.get("length") * m.get("width") + m.get("length") * m.get("height") + m.get("width") * m.get("height"));
            m.put("totalSurface", totalSurface);
        }
    }

    @AllArgsConstructor
    private class Step2 implements Step {
        RectangularParallelepiped p;

        // baseSurface = l * w
        public void executeStep() {
            var m = p.getDetails();
            Float baseSurface = m.get("length") * m.get("width");
            m.put("baseSurface", baseSurface);
        }
    }

    @AllArgsConstructor
    private class Step3 implements Step {
        RectangularParallelepiped p;

        // lateralSurface = 2(l * w + w * h)
        public void executeStep() {
            var m = p.getDetails();
            Float lateralSurface = 2 * (m.get("length") * m.get("width") + m.get("width") * m.get("height"));
            m.put("lateralSurface", lateralSurface);
        }

        @Override
        public String toString() {
            return "lateralSurface = 2(l * w + w * h)";
        }
    }

    @AllArgsConstructor
    private class Step4 implements Step {
        RectangularParallelepiped p;

        // volume = l * w * h
        public void executeStep() {
            var m = p.getDetails();
            Float volume = m.get("length") * m.get("width") * m.get("height");
            m.put("volume", volume);
        }

        @Override
        public String toString() {
            return "volume = l * w * h";
        }
    }

    @AllArgsConstructor
    private class Step5 implements Step {
        RectangularParallelepiped p;

        // basePerimeter = 2(l + w)
        public void executeStep() {
            var m = p.getDetails();
            Float basePerimeter = 2 * (m.get("length") + m.get("width"));
            m.put("basePerimeter", basePerimeter);
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
        RectangularParallelepiped p;

        // w = bS / l
        public void executeStep() {
            var m = p.getDetails();
            Float width = m.get("baseSurface") / m.get("length");
            m.put("width", width);
        }

        @Override
        public String toString() {
            return "w = bS / l";
        }
    }
}

