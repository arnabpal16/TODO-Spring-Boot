# ---------- STAGE 1: Build with Maven (JDK 21) ----------
FROM maven:3-eclipse-temurin-21 AS build

WORKDIR /workspace

# copy pom.xml first for caching
COPY pom.xml .

# download dependencies
RUN mvn -B dependency:go-offline

# copy source
COPY . .

# build the Spring Boot fat JAR (remove -DskipTests to run tests)
RUN mvn -B clean package -DskipTests

# ---------- STAGE 2: Runtime (JRE 21) ----------
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# copy jar from build stage
COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
