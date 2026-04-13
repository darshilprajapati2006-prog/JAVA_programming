# SVNIT Course Registration System - AP-2

## Project Overview

This project is the `Assignment 2` enhanced version of the AP-1 `University Course Registration System` built for `CSE201 Advanced Programming`.

The AP-2 solution keeps the original terminal-based, menu-driven course registration workflow intact and adds the new concepts required in the assignment:

- `Generic Programming`
- `Object Classes and Inheritance`
- `Custom Exception Handling`

The system context remains based on:

- `Sardar Vallabhbhai National Institute of Technology (SVNIT), Surat`
- `Department of Artificial Intelligence`
- `Integrated B.Tech + M.Tech in Artificial Intelligence`

## User Roles

The application supports four roles:

- `Student`
- `Teaching Assistant`
- `Professor`
- `Administrator`

## AP-2 Enhancements Implemented

### 1. Generic Feedback System

Requirement covered:
- students can give feedback only on completed courses
- feedback supports different data types
- professors can view feedback through their interface

Implementation:
- [Feedback.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/Feedback.java) is implemented as a generic class: `Feedback<T>`
- numeric feedback is stored using `Feedback<Integer>`
- textual feedback is stored using `Feedback<String>`
- [FeedbackService.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/service/FeedbackService.java) handles validation, creation, and retrieval
- [StudentMenu.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/menu/StudentMenu.java) provides student options for numeric and text feedback
- [ProfessorMenu.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/menu/ProfessorMenu.java) provides professor feedback viewing

Rules implemented:
- feedback is allowed only for completed courses
- numeric rating must be between `1` and `5`
- text feedback cannot be empty
- one student cannot submit the same feedback type twice for the same course

### 2. Teaching Assistant Role Using Inheritance

Requirement covered:
- introduce a new role `Teaching Assistant`
- TA must inherit from `Student`
- TA should have student capabilities with extra grade-assistance functionality
- TA should not get full professor privileges

Implementation:
- [TeachingAssistant.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/TeachingAssistant.java) extends [Student.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/Student.java)
- [TAService.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/service/TAService.java) handles TA-specific grade assistance
- [TAMenu.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/menu/TAMenu.java) provides TA dashboard options
- [AuthMenu.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/menu/AuthMenu.java) adds separate TA login/signup flow
- [AuthService.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/service/AuthService.java) supports TA account registration and login

TA capabilities:
- all student capabilities inherited from `Student`
- view assigned TA courses
- view students in TA-assigned courses
- manage grades only for TA-assigned courses

TA restrictions:
- cannot update course syllabus
- cannot update course timings
- cannot update credits
- cannot update prerequisites
- cannot update enrollment limit
- cannot add/delete courses

### 3. Robust Exception Handling

Requirement covered:
- full course registration must throw a custom exception
- invalid login must throw a custom exception
- course drop after deadline must throw a custom exception
- exceptions must be handled using `try-catch`

Custom exceptions created:
- [CourseFullException.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/exception/CourseFullException.java)
- [InvalidLoginException.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/exception/InvalidLoginException.java)
- [DropDeadlinePassedException.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/exception/DropDeadlinePassedException.java)

Where they are used:
- [AuthService.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/service/AuthService.java) throws `InvalidLoginException`
- [StudentService.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/service/StudentService.java) throws `CourseFullException` and `DropDeadlinePassedException`
- [StudentMenu.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/menu/StudentMenu.java), [TAMenu.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/menu/TAMenu.java), and [AuthMenu.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/menu/AuthMenu.java) handle them using `try-catch`

Additional model support:
- [Enrollment.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/Enrollment.java) now stores `registrationDate` and `dropDeadline`

## Existing Features Preserved From AP-1

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
- update allowed course details
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

## OOP Concepts Demonstrated

### Abstraction

- [User.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/User.java) is an abstract base class

### Inheritance

- [Student.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/Student.java) extends `User`
- [TeachingAssistant.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/TeachingAssistant.java) extends `Student`
- [Professor.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/Professor.java) extends `User`
- [Administrator.java](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/src/model/Administrator.java) extends `User`

### Encapsulation

- all major fields are private
- updates happen through constructors, getters, setters, and controlled helper methods

### Polymorphism

- role classes override shared methods such as `getRoleName()` and `showBasicProfile()`

### Generic Programming

- `Feedback<T>` stores different feedback value types with the same generic structure

### Composition and Association

- student maintains `Enrollment` and `Complaint` records
- course maintains `ScheduleSlot` entries and enrolled students
- professor and TA interact with courses through controlled service-layer logic

## Project Structure

```text
AP-2/
  README.md
  AP2_IMPLEMENTATION_PLAN.md
  DEMONSTRATION_GUIDE.md
  REQUIREMENTS_FREEZE.md
  OOP_DESIGN_FREEZE.md
  UML_DRAFT.md
  UML_FINAL.html
  UML_FINAL.mmd
  UML_FINAL.pdf
  UML_FINAL.png
  src/
    Main.java
    data/
    exception/
    menu/
    model/
    service/
    util/
```

## Compilation

Run from the project root:

```bash
find src -name '*.java' -print0 | xargs -0 javac
```

## Execution

After compilation:

```bash
java -cp ./src Main
```

## Demo Credentials

### Student Demo

- Success case:
  Email: `i25ai001@students.aid.svnit.ac.in`
  Password: `Student@123`
- Prerequisite blocked case:
  Email: `i25ai005@students.aid.svnit.ac.in`
  Password: `Student@123`
- Full course exception case:
  Email: `i25ai002@students.aid.svnit.ac.in`
  Password: `Student@123`

### Teaching Assistant Demo

- Email: `ta001@students.aid.svnit.ac.in`
- Password: `TA@123`

### Professor Demo

- Email: `rahulshrivastava@aid.svnit.ac.in`
- Password: `Prof@123`

### Administrator Demo

- ID: `ADMIN01`
- Password: `Admin@123`

## Seeded Demonstration Data

The system starts with:

- `63` students
- `1` teaching assistant
- `9` professors
- `1` administrator
- `53` courses
- `8` complaints

Special AP-2 seeded demo cases:

- completed course `IA101` available for feedback demo
- TA assigned to `IA102` and `IA101`
- `IA102` seeded as full-course exception demo
- `STU001` enrollment in `IA102` seeded with expired drop deadline

## Academic Rules Implemented

- registration allowed only for current semester courses
- prerequisite validation before registration
- registration blocked if already registered
- registration blocked if already completed
- registration blocked if credit limit exceeds `20`
- registration blocked if course is full
- course completion recognized only after grade assignment
- SGPA shown only when semester is complete
- CGPA computed from completed courses

## Grading Scale

- `AA = 10`
- `AB = 9`
- `BB = 8`
- `BC = 7`
- `CC = 6`
- `CD = 5`
- `DD = 4`
- `FF = 0`

Accepted aliases for robustness:

- `A = 10`
- `B = 8`
- `C = 6`
- `D = 4`
- `F = 0`

## Assumptions

- all data is stored in-memory using Java collections
- no file/database persistence is used
- changes survive only for the current execution
- the AP-2 version builds directly on the stable AP-1 system
- one numeric and one textual feedback entry are allowed per student per completed course
- default drop deadline is `7` days from registration unless demo data overrides it

## Submission Notes

- the directory structure is clean and separated by responsibility
- AP-2 features are documented in this README
- demonstration examples are provided in [DEMONSTRATION_GUIDE.md](/Users/darshilprajapati/Desktop/JAVA programming/src/AP-2/DEMONSTRATION_GUIDE.md)
- UML and design freeze documents are included with the project
