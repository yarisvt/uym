# UYM

Spring Boot + Angular application for a lightweight landing site. The project bundles a Spring Boot backend and an Angular frontend into a single deployable artifact.

---

## Overview
UYM provides a simple landing website served by Spring Boot. The Angular app is located under `src/main/uym` and is built automatically during the Maven build, producing a single executable jar.

## Tech stack
- Java 25, Maven 3.9+
- Spring Boot 3.5.7 (Web, Security, Actuator)
- springdoc-openapi (UI + Maven plugin)
- Angular (generated client support set to Angular 20)
- Node v25.0.0 and npm 11.6.2 (installed via `frontend-maven-plugin` for builds)
- Eclipse JKube for container build/push

## Getting started
Prerequisites for local development:
- JDK 25 (Temurin recommended)
- Maven 3.9+
- Optional: A local Node.js (v20+ works; v25.x matches build plugin). Not strictly required for Maven builds because the Node toolchain is provisioned by the build.

Clone and build:
```bash
mvn -B clean install
```
This will:
- Install the configured Node+npm toolchain (isolated under `target/`)
- Build the Angular app in `src/main/uym`
- Package everything into `target/uym-<version>.jar`

Run the packaged application:
```bash
java -jar target/uym-*.jar
# or during development
mvn spring-boot:run
```
By default, the app runs on port 8080.

## Development workflows

### Run backend only
Useful when iterating on REST endpoints.
```bash
mvn spring-boot:run
```

### Run Angular dev server (hot reload)
If you prefer running the Angular app with hot reload, use your local Node environment:
```bash
cd src/main/uym
npm install
npm run start   # serves at http://localhost:4200
```
The backend normally runs at `http://localhost:8080`. Configure API base URLs or a dev proxy as needed.

### Full build (backend + frontend)
The repository is configured to build Angular automatically as part of the Maven lifecycle using `frontend-maven-plugin`:
```bash
mvn clean package
```
The resulting fat jar is in `target/uym-<version>.jar`.

### Testing
Standard Spring Boot test suite:
```bash
mvn -B verify
```

## OpenAPI (Swagger) and Angular API generation
- API docs are exposed by springdoc at runtime: `http://localhost:8080/swagger-ui.html` (or `/swagger-ui` depending on browser redirect).
- The Maven build can generate an Angular TypeScript client under `src/main/uym/src/api` using `openapi-generator-maven-plugin`.
- The `springdoc-openapi-maven-plugin` is configured to fetch docs from `http://localhost:18880/v3/api-docs` during generation phases. To regenerate the client locally:
  1) Start the backend on port 18880:
     ```bash
     mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=18880
     ```
  2) In another terminal, run the generation phases:
     ```bash
     mvn -DskipTests=true generate-test-sources generate-test-resources
     ```
  The generated client will appear in `src/main/uym/src/api` with Angular 20-compatible types.

## Containerization with Eclipse JKube
This project uses JKube to create and push container images. Examples:
```bash
# Build container image (adjust registry)
mvn validate k8s:resource k8s:build -Djkube.generator.registry=$CI_REGISTRY

# Push image
mvn validate -DskipTests=true k8s:push \
  -Djkube.docker.push.registry=$CI_REGISTRY \
  -Djkube.docker.username=$CI_REGISTRY_USER \
  -Djkube.docker.password=$CI_REGISTRY_PASSWORD
```
Required environment variables when pushing:
- `CI_REGISTRY`
- `CI_REGISTRY_USER`
- `CI_REGISTRY_PASSWORD`

The application container exposes port 8080 (as configured in the POM’s JKube properties).

## Useful URLs (local)
- App: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- Actuator: `http://localhost:8080/actuator`

---
