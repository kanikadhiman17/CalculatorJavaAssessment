# Calculator Java Assessment
This is a Calculator Java Assessment which does basic calculations in Default or Custom Modes, calculates arithmetical expressions, and send the logs to the mail, if requested.

Skeleton code taken from https://github.com/16DF35DC5E7F679EF7C096F61B79B679/calculator-java-assessment

### Requirements:
Eclipse Photon <br />
JDK - 14.0.2<br />

### Dependencies
Project Created in Maven, dependencies and versions mentioned in in pom.xml<br />
junit - 4.13<br />
mockito-all - 2.0.2-beta<br />
opencsv - 4.4<br />
commons-lang3 - 3.9<br />
javax mail - mail - 1.4<br />
org.apache.poi.xwpf.converter - 0.9.1<br />

### Note
1. Please change the file "/src/main/java/com/kanika/calculatorJavaAssessment/logging/OperationsLogger.java" and add your own e-mail ID and change the Signature.<br />
2. Please open the file "/src/main/java/com/kanika/calculatorJavaAssessment/logging/notification/MailSender.java" and add the password to your GMail ID in the line 25. If the mail is to be sent from an Organization e-mail ID, host, port, and properties are to be changed accordingly. <br />
3. If mails are being sent through GMail, please Allow the "Less Secure App Access".<br />

### Test Cases
CalculatorBasicTest.java - Tests basic functionalities like addition, subtraction, division and multiplication in Default and Custom Modes.<br />
CalculatorExpressonTest.java - Tests the calculation of Arithmetic Expressions.<br />
MailTest.java - Tests if mailing functionality is working properly. Add a valid e-mail ID to test.<br />
DefaultAdderTest.java - Tests Default Addition<br />
DefaultDividerTest.java - Tests Default Division<br />
DefaultMultiplierTest.java - Tests Default Multiplication<br />
DefaultSubtractorTest.java - Tests Default Subtraction<br />
