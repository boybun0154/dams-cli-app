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

## Docker

You can find the official Docker image for this application on Docker Hub:
[boybun0154/dams-cli-app on Docker Hub](https://hub.docker.com/repository/docker/boybun0154/dams-cli-app)

## CI/CD Pipeline (GitHub Actions)

This project includes an automated CI/CD pipeline configured with GitHub Actions. The workflow is defined in [.github/workflows/docker-publish.yml](.github/workflows/docker-publish.yml).

### Pipeline Workflow:
1. **Build & Test**: On every push or pull request to the `master`/`main` branches, the pipeline compiles the code and runs verification tests using JDK 25.
2. **Publish Docker Image**: On every merge/push to `master`/`main`, it logs into Docker Hub, builds the Docker image using the multi-stage [Dockerfile](Dockerfile), and pushes it to [Docker Hub](https://hub.docker.com/repository/docker/boybun0154/dams-cli-app).

### Setup Secrets:
To enable Docker Hub publishing, configure the following secrets under your GitHub repository **Settings** -> **Secrets and variables** -> **Actions**:
- `DOCKER_USERNAME`: Your Docker Hub username.
- `DOCKER_PASSWORD`: Your Docker Hub Personal Access Token (PAT) or password.


