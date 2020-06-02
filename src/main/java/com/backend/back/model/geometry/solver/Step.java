package com.backend.back.model.geometry.solver;

import java.util.List;

public interface Step {
    void executeStep();
    List<String> getKnownProperties();
    String getUnknownProperty();
    List<String> getFormulas();
}
