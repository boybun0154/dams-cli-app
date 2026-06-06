# Dentist Appointment Management System (DAMS)

A Java-based Command Line Interface (CLI) application for managing dentist appointments.

## Requirements

To run this application, you will need:
- **Java Development Kit (JDK) 25** or newer.
- **Apache Maven 3.6.0** or newer.

## Getting Started

### 1. Compile the Application
Use Maven to clean and compile the project:
```bash
mvn clean compile
```

### 2. Run the Application
You can run the application directly using the Maven Exec plugin:
```bash
mvn exec:java -Dexec.mainClass="dams.DAMSApp"
```

Alternatively, you can package the application into a runnable fat JAR and run it:
```bash
mvn clean package
java -jar target/dams-cli-app-1.0-SNAPSHOT.jar
```
