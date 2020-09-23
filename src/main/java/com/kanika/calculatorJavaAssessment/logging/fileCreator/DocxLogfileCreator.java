package com.kanika.calculatorJavaAssessment.logging.fileCreator;

import com.kanika.calculatorJavaAssessment.Operation;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class DocxLogfileCreator implements LogfileCreator{
    @Override
    public File createLogFile(List<Operation> operations) {
    	
    	//Blank Document
    	XWPFDocument document = new XWPFDocument(); 

    	String fileLocation = System.getProperty("user.dir")+"/src/main/java/com/kanika/calculatorJavaAssessment/logging/fileCreator/DOCXOutput.docx";
    	FileOutputStream out;
		try {
			out = new FileOutputStream(new File(fileLocation));
			//create table
	        XWPFTable table = document.createTable();
	        
	        //create first row
	        XWPFTableRow tableRowOne = table.getRow(0);
	        tableRowOne.getCell(0).setText("Number");
	        tableRowOne.addNewTableCell().setText("Operation");
	                  
	        
	        for(int i=0;i<operations.size();i++)
	        {
	        	XWPFTableRow newRow = table.createRow();
	        	newRow.getCell(0).setText(String.valueOf(i+1));
	        	newRow.getCell(1).setText(operations.get(i).toString());
	        }
       
			document.write(out);
	        out.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

		File file = new File(fileLocation);
        return file;
    }
}
