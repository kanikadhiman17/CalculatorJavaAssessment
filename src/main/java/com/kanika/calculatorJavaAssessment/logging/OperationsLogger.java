package com.kanika.calculatorJavaAssessment.logging;

import com.kanika.calculatorJavaAssessment.FileFormat;
import com.kanika.calculatorJavaAssessment.LoggingStrategy;
import com.kanika.calculatorJavaAssessment.Operation;
import com.kanika.calculatorJavaAssessment.logging.fileCreator.LogfileCreator;
import com.kanika.calculatorJavaAssessment.logging.fileCreator.LogfileCreatorFactory;
import com.kanika.calculatorJavaAssessment.logging.notification.MailSender;
import com.kanika.calculatorJavaAssessment.logging.notification.Notification;
import com.kanika.calculatorJavaAssessment.logging.notification.NotificationsSender;

import java.io.File;
import java.util.List;

public class OperationsLogger {

    LogfileCreator logfileCreator;

    NotificationsSender notificationsSender;

    public OperationsLogger() {
    }

    private LogfileCreator getLogfileCreator(FileFormat fileFormat) {
        if (logfileCreator == null) {
            logfileCreator = LogfileCreatorFactory.create(fileFormat);
        }
        return logfileCreator;
    }

    private NotificationsSender getNotificationsSender() {
        if (notificationsSender == null) {
            notificationsSender = new MailSender();
        }
        return notificationsSender;
    }

    public void logOperations(List<Operation> operations, LoggingStrategy loggingStrategy) {
        // Get logfile creator instance and create file
    	LogfileCreator logFile = getLogfileCreator(loggingStrategy.fileFormat);
    	File attachment = logFile.createLogFile(operations);
    	
        // Create an instance of Notification  	
    	Notification notification = new Notification();	   
    	notification.setSubject("Calculator Log File");
    	notification.setFromAddress("xyz@gmail.com");
    	notification.setSignature("Regards, \nKanika Dhiman");
    	notification.setMessage("PFA the requested calculator logs file.");
    	notification.setToAddress(loggingStrategy.email);
    	notification.setAttachment(attachment);
    	
        // Obtain an instance of notification sender and send notification    	
    	NotificationsSender notificationsSender = getNotificationsSender();
    	notificationsSender.sendNotification(notification);
    }
}
