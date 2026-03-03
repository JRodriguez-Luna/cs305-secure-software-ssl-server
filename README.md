# CS 305 – Secure Software: SSL Server Project

**Course:** CS 305 – Software Security  
**Institution:** Southern New Hampshire University  
**Client (Fictional):** Artemis Financial  
**Type:** Academic Project

---

## Overview

This project involved refactoring an existing Spring Boot web application for Artemis Financial, a fictional financial services company, to meet modern software security standards. The goal was to identify vulnerabilities and apply industry-standard security practices — specifically implementing **SHA-256 data integrity checks** and upgrading the application from HTTP to **HTTPS using SSL/TLS encryption**.

---

## What's in This Repo

| File | Description |
|------|-------------|
| `ssl-server_student/` | Refactored Spring Boot application with SHA-256 hashing and HTTPS enabled |
| `CS 305 Project Two.pdf` | Practices for Secure Software Report documenting the full process |

---

## What Was Done

### 1. SHA-256 Hashing (Data Integrity)
Added a `/hash` REST endpoint to the `ServerController` class that uses Java's built-in `MessageDigest` API to generate a SHA-256 checksum for any input data. This allows the application to verify that data has not been tampered with in transit.

### 2. SSL Certificate Generation (Secure Communications)
Used **Java Keytool** to generate a self-signed SSL certificate (`server.cer`) and configured the application to run over HTTPS on port `8443`. The `application.properties` file was updated with the keystore path, password, and certificate alias.

### 3. OWASP Dependency-Check
Ran the **OWASP Dependency-Check Maven plugin** to scan all third-party dependencies for known CVEs. Confirmed that no new vulnerabilities were introduced by the refactored code — all flagged issues originated from existing third-party libraries.

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Framework | Spring Boot 2.2.4 |
| Language | Java |
| Build Tool | Maven |
| Security | Java Keytool, SSL/TLS, SHA-256 (MessageDigest API) |
| Vulnerability Scanning | OWASP Dependency-Check |

---

## Key Security Concepts Demonstrated

- **SHA-256 hashing** for file and data integrity verification, following NIST FIPS 180-4 standards
- **HTTPS/TLS** to encrypt all client-server traffic and prevent eavesdropping or man-in-the-middle attacks
- **Self-signed certificate** generation for development/testing (production would use a trusted CA)
- **Secure dependency management** using OWASP tooling to detect vulnerable third-party components
- Understanding the difference between **hashing** (integrity) and **encryption** (confidentiality)

---

## Running the Application

```bash
# Clone the repo and navigate to the project folder
cd ssl-server_student

# Build and run with Maven
./mvnw spring-boot:run

# Visit the hash endpoint
https://localhost:8443/hash
```

> Note: Since a self-signed certificate is used, your browser will show a security warning. This is expected in a development environment.

---

## Skills Demonstrated

- **Software Security** – identifying and mitigating vulnerabilities in a real codebase
- **Secure Coding Practices** – applying NIST and OWASP standards to Java development
- **SSL/TLS Configuration** – enabling HTTPS in a Spring Boot application
- **Cryptography Fundamentals** – implementing SHA-256 hashing for data integrity
- **Vulnerability Assessment** – using automated tools to detect and document CVEs

---

## Notes

This is an academic project. The SSL certificate included is self-signed and intended for development/testing only. In a production environment, a certificate from a trusted Certificate Authority (CA) would be required.
