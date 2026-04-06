# SVNIT Course Registration System

## Project Overview

This project is a terminal-based, menu-driven `University Course Registration System` built for `CSE201 Advanced Programming`.

The system is modeled around the real context of:

- `Sardar Vallabhbhai National Institute of Technology (SVNIT), Surat`
- `Department of Artificial Intelligence`
- `Integrated B.Tech + M.Tech in Artificial Intelligence`

It supports three user roles:

- `Student`
- `Professor`
- `Administrator`

The application is designed using OOP principles and includes realistic seeded academic data for demonstration.

## Features

### Student Features

- student signup and login
- view available semester courses
- register for courses
- drop courses
- view weekly schedule
- track academic progress
- view SGPA and CGPA
- submit complaints
- view complaint status

### Professor Features

- professor signup and login
- view assigned courses
- update only allowed course fields
- view enrolled students
- assign grades
- update office hours

### Administrator Features

- fixed-password admin login
- view course catalog
- add courses
- delete courses
- assign professors to courses
- view student records
- update student name and semester
- assign grades
- view all complaints
- filter complaints by status
- filter complaints by date
- resolve complaints with resolution notes

## OOP Concepts Used

### Abstraction

- `User` is implemented as an abstract base class in [User.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-1/src/model/User.java)

### Inheritance

- [Student.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-1/src/model/Student.java) extends `User`
- [Professor.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-1/src/model/Professor.java) extends `User`
- [Administrator.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-1/src/model/Administrator.java) extends `User`

### Encapsulation

- all major model fields are private
- access is controlled through constructors, getters, setters, and helper methods

### Polymorphism

- role classes override shared methods like `getRoleName()` and `showBasicProfile()`

### Composition and Association

- a student maintains `Enrollment` records
- a student maintains `Complaint` records
- a course contains `ScheduleSlot` objects
- professors manage assigned courses
- administrators manage records and complaints

## Project Structure

```text
src/
  Main.java
  model/
  service/
  menu/
  data/
  util/
```

Main supporting documents:

- [REQUIREMENTS_FREEZE.md](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-1/REQUIREMENTS_FREEZE.md)
- [OOP_DESIGN_FREEZE.md](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-1/OOP_DESIGN_FREEZE.md)
- [UML_DRAFT.md](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-1/UML_DRAFT.md)

## How To Compile

Run from the project root:

```bash
find src -name '*.java' -print0 | xargs -0 javac
```

## How To Run

After compilation, run:

```bash
java -cp ./src Main
```

## Demo Credentials

### Student Demo

- Success case:
  - Email: `i25ai001@students.aid.svnit.ac.in`
  - Password: `Student@123`

- Prerequisite blocked case:
  - Email: `i25ai005@students.aid.svnit.ac.in`
  - Password: `Student@123`

### Professor Demo

- Email: `rahulshrivastava@aid.svnit.ac.in`
- Password: `Prof@123`

### Administrator Demo

- ID: `ADMIN01`
- Password: `Admin@123`

## Demo Data Included

The application starts with preloaded data:

- `63 students`
- `9 professors`
- `1 administrator`
- `53 courses`
- `8 complaints`

The dataset includes:

- complete student roster for the shared AI division list
- AI faculty records
- semester-wise course catalog
- active registrations
- completed courses with grades
- pending and resolved complaints

## Academic Rules Implemented

- registration allowed only for current semester courses
- prerequisite validation before registration
- registration blocked if already registered
- registration blocked if already completed
- registration blocked if credit limit exceeds `20`
- registration blocked if enrollment limit is full
- course completion is recognized only after grade assignment
- SGPA is shown only when the semester is complete
- CGPA is computed from completed courses

## Grading Scale

Primary project grading follows the SVNIT-style 10-point letter scale:

- `AA = 10`
- `AB = 9`
- `BB = 8`
- `BC = 7`
- `CC = 6`
- `CD = 5`
- `DD = 4`
- `FF = 0`

The system also accepts simplified aliases for robustness:

- `A = 10`
- `B = 8`
- `C = 6`
- `D = 4`
- `F = 0`

## Assumptions

- data is stored in-memory using `ArrayList`
- changes remain active only during the current execution
- file/database persistence is not implemented in the current version
- semester 1 and semester 2 data is the most detailed and closest to the available official references
- later semester course catalog is seeded using official curriculum-aligned course codes and realistic placeholders where detailed public timetable data was not available

## Notes For Evaluation

- professors cannot add or delete courses
- only administrators can add/delete courses and resolve complaints
- complaint status can be changed only by admin
- the project intentionally separates model, service, menu, and data layers to keep the design clean and explainable

## Suggested Demo Flow

1. Login as admin and view course catalog
2. Filter complaints by status
3. Login as professor and view assigned courses
4. Login as student and view available courses
5. Show successful registration or blocked prerequisite case
6. Show academic progress and complaint status
