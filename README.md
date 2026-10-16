# Student Management System (Java CRUD)

A console-based student management system that supports creating, reading, updating and deleting student records.

## Requirements

- JDK 17 or later
- No Maven installation needed: the project ships with the Maven Wrapper, which downloads Maven on first run

## Build and run

```bash
# macOS / Linux
./mvnw package
java -jar target/java-crud-1.0-SNAPSHOT.jar

# Windows
mvnw.cmd package
java -jar target\java-crud-1.0-SNAPSHOT.jar
```

You can also open the project root in IntelliJ IDEA (it is detected as a Maven project) and run `Main`.

## Features

| Option | Function |
| --- | --- |
| 1 | Add student |
| 2 | List all students |
| 3 | Find student by ID |
| 4 | Update student |
| 5 | Delete student |
| 0 | Exit |

## Project structure

```
src/
├── Main.java            # Console menu and input handling
├── Student.java         # Student entity
└── StudentService.java  # CRUD logic
doc/                     # Screenshots and run logs
```
