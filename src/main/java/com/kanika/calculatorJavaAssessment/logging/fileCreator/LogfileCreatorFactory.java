package com.kanika.calculatorJavaAssessment.logging.fileCreator;

import com.kanika.calculatorJavaAssessment.FileFormat;

public class LogfileCreatorFactory {

    public static LogfileCreator create(FileFormat fileFormat) {
        switch (fileFormat) {
            case csv:
                return new CsvLogfileCreator();
            case txt:
                return new TxtLogfileCreator();
            case docx:
                return new DocxLogfileCreator();
            default:
                throw new RuntimeException("File format not supported");
        }
    }
}
