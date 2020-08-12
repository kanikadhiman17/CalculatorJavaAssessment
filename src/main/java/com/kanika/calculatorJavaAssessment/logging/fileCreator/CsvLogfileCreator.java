package com.kanika.calculatorJavaAssessment.logging.fileCreator;

import com.kanika.calculatorJavaAssessment.Operation;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvLogfileCreator implements LogfileCreator {
    @Override
    public File createLogFile(List<Operation> operations) {
    	
    	List<String[]> dataLines = new ArrayList<>();
    	dataLines.add(new String[] {"Number", "Operation"});
    	for(int i=0;i<operations.size();i++)
    		dataLines.add(new String[] {String.valueOf(i+1), operations.get(i).toString()});

    	String fileLocation = System.getProperty("user.dir")+"/src/main/java/com/kanika/calculatorJavaAssessment/logging/fileCreator/CSVOutput.csv";
    	
    	try 
    	{
			@SuppressWarnings("resource")
			CSVWriter writer = new CSVWriter(new FileWriter(fileLocation));
			writer.writeAll(dataLines);
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	File file = new File(fileLocation);
        return file;
    }
}
