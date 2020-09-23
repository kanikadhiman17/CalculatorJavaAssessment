package com.kanika.calculatorJavaAssessment.logging.fileCreator;

import com.kanika.calculatorJavaAssessment.Operation;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class TxtLogfileCreator implements LogfileCreator {
    @Override
    public File createLogFile(List<Operation> operations) {
    	
		String fileLocation = System.getProperty("user.dir")+"/src/main/java/com/kanika/calculatorJavaAssessment/logging/fileCreator/TXTOutput.txt";

		try {
			FileOutputStream out = new FileOutputStream(fileLocation);
			String data = "Number, Operation \n";

			for(int i=0;i<operations.size();i++)
				data+=String.valueOf(i+1) + ", " + operations.get(i).toString() + '\n';

			out.write(data.getBytes());
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		File file = new File(fileLocation);
		return file;
    }
}
