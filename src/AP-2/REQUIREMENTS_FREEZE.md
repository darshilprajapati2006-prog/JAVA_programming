# Requirements Freeze

## Project Identity

- Project title: `SVNIT Course Registration System`
- Institute: `Sardar Vallabhbhai National Institute of Technology (SVNIT), Surat`
- Department: `Artificial Intelligence`
- Programme: `Integrated B.Tech + M.Tech in Artificial Intelligence`
- Target mode: `Terminal-based menu-driven Java application`

## Assignment Scope Lock

This document freezes the scope for Assignment-1 implementation. Any coding, menus, classes, validations, UML, and documentation must follow this sheet so that no required feature is missed later.

## Mandatory Assignment Requirements

- Roles supported:
  - `Student`
  - `Professor`
  - `Administrator`
- Application type:
  - `Terminal-based`
  - `Menu-driven`
  - `Role-based navigation`
- Authentication:
  - `Student signup/login`
  - `Professor signup/login`
  - `Administrator fixed-password login`
- UI flow:
  - main menu
  - login menu
  - role-specific dashboards
  - submenu-based flow allowed
  - logout and safe exit required
- OOP requirements:
  - classes
  - abstraction
  - encapsulation
  - inheritance
  - polymorphism
  - interfaces may be used if needed
- Deliverables:
  - source code
  - UML diagram
  - README documentation
- Demo data:
  - assignment minimum says `3 students, 2 professors, 1 admin, 5 courses`
  - this project will use `full realistic seeded data`, not minimum demo-only data

## Realistic Data Scope Lock

The project will not be built with only the assignment minimum entities. It will use the larger verified dataset collected from official SVNIT sources and user-shared class records.

### Students

- Total students to be seeded: `63`
- Batch division used in project: `Division A`
- Roll numbers: `A01` to `A63`
- Admission numbers: `I25AI001` to `I25AI063`
- Programme tag: `IPG AI`
- Current seeded semester for active registration flow: `Semester 2`

### Professors

- Total AI faculty to be seeded: `9`
- Faculty list to seed:
  - `Dr. Tanmoy Hazra`
  - `Dr. Rahul Dixit`
  - `Dr. Nitesh A. Funde`
  - `Dr. Praveen Kumar Chandaliya`
  - `Dr. Pruthwik Mishra`
  - `Dr. Rohit Kumar`
  - `Dr. Rahul Shrivastava`
  - `Dr. Sankhadeep Chatterjee`
  - `Dr. Sudhakar Mishra`

### Administrator

- Total administrators to seed: `1`
- Initial system admin:
  - display name: `Academic Admin`
  - admin id: `ADMIN01`
  - password: to be defined in implementation step

### Courses

- The application will support a realistic multi-semester catalog based on the official IPG AI curriculum.
- The active registration and schedule workflow will initially focus on `Semester 2`.
- Core seeded Semester 2 courses:
  - `IA102 - Data Structures`
  - `IA104 - Web Programming and Python`
  - `EG110 - Energy and Environmental Engineering`
  - `MA106 - Discrete Mathematics`
  - `EC106 - Digital Electronics and Logic Design`
  - `HS120 - Indian Value System and Social Consciousness`
- Additional curriculum data from later semesters may also be seeded for realism, progression, and prerequisite support.

## Functional Scope by Role

### Student Functionalities

- View available courses for the current semester
- Register for courses
- View weekly schedule
- Track academic progress
- Drop courses
- Submit complaints
- View complaint status

### Professor Functionalities

- View assigned courses
- Update allowed course details
- View enrolled students
- Assign grades to enrolled students

### Administrator Functionalities

- View course catalog
- Add courses
- Delete courses
- View and update student records
- Assign professors to courses
- View all complaints
- Update complaint status
- Filter complaints by status and/or date

## Validation Rules Lock

The following rules must be implemented unless a later requirement document explicitly updates them.

- Student can register only in courses offered for the current semester
- Prerequisites must be satisfied before registration
- Registration must fail if the student is already registered in the same course
- Registration must fail if the course reaches enrollment limit
- Registration must fail if the credit limit is exceeded
- Semester completion and academic progress must depend on assigned grades
- Complaint status can only be changed by the administrator
- Professors may update course details but cannot add/delete courses
- Only administrators can add/delete courses and assign professors

## Academic Rules Lock

- Academic system type: `Semester system`
- Programme duration: `10 semesters`
- Credit and GPA system: `10-point grading`
- Grade mapping:
  - `AA = 10`
  - `AB = 9`
  - `BB = 8`
  - `BC = 7`
  - `CC = 6`
  - `CD = 5`
  - `DD = 4`
  - `FF = 0`
- Additional academic statuses supported:
  - `II`
  - `NA`
  - `WW`
  - `XX`
- SGPA calculation: weighted average of course credits and grade points for a semester
- CGPA calculation: weighted average across completed/passed courses

## Menu Flow Lock

- Welcome screen
  - enter application
  - exit application
- Authentication screen
  - student login
  - student signup
  - professor login
  - professor signup
  - administrator login
- Student menu
  - all student functionalities
  - logout
- Professor menu
  - all professor functionalities
  - logout
- Administrator menu
  - all administrator functionalities
  - logout
- Nested submenus are allowed and encouraged where useful

## Data Realism Policy

- Institute, department, programme, curriculum, timetable, grading system, and faculty data must be based on official SVNIT sources wherever available.
- Student roster must use the provided class list data.
- Sensitive or non-public fields such as passwords, complaint history, and some login emails may be system-generated but must look realistic and consistent with the institute context.
- Any system-generated assumptions must be documented later in the README.

## Out of Scope for Step 1

- No Java classes yet
- No menu implementation yet
- No seed data coding yet
- No UML drawing yet
- No README writing yet

## Completion Condition for Step 1

Step 1 is complete when:

- all mandatory requirements are written and frozen
- the project is confirmed to use full realistic seeded data instead of only minimum demo data
- role features are locked
- validation rules are locked
- academic rules are locked
- menu flow expectations are locked

## Approved Source Basis

- Official SVNIT website
- Official SVNIT AI department pages
- Official SVNIT academic regulations
- Official SVNIT IPG AI curriculum and timetable
- User-shared student batch list images and supporting academic files
