package com.kanika.calculatorJavaAssessment.logging.fileCreator;

import com.kanika.calculatorJavaAssessment.Operation;

import java.io.File;
import java.util.List;

public interface LogfileCreator {

    File createLogFile(List<Operation> operations);
}
