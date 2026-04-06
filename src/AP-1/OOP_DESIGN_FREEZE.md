# OOP Design Freeze

## Purpose

This document freezes the object-oriented design for the `SVNIT Course Registration System`. The goal is to make the OOP concepts explicit, intentional, and easy to justify during evaluation, UML explanation, and README documentation.

This design is final unless a later freeze document explicitly updates it.

## Design Goals

- show strong and visible OOP usage
- keep the design clean enough for a terminal-based assignment
- avoid unnecessary complexity
- support full realistic seeded SVNIT data
- support all required role-based functionalities
- make UML straightforward to draw

## Core OOP Strategy

### Abstraction

- `User` will be an `abstract class`
- common behavior and identity fields will be defined only once in `User`

### Inheritance

- `Student extends User`
- `Professor extends User`
- `Administrator extends User`

### Encapsulation

- all class fields will be `private`
- access and updates will happen through constructors, getters, setters, and controlled methods

### Polymorphism

- child classes will override shared abstract methods from `User`
- role-specific behavior will be handled through overridden methods such as:
  - `getRoleName()`
  - `showBasicProfile()`

### Association and Composition

- a `Student` has many `Enrollment` records
- a `Student` has many `Complaint` records
- a `Professor` is associated with many `Course` objects
- a `Course` contains many `ScheduleSlot` objects
- a `Course` is linked to enrolled students through `Enrollment`

### Interface Usage

- an interface may be used later only if it improves clarity
- interface usage is optional, not mandatory for this design
- current freeze does not require a custom interface for correctness

## Final Package Structure

```text
src/
  Main.java

  model/
    User.java
    Student.java
    Professor.java
    Administrator.java
    Course.java
    Enrollment.java
    Complaint.java
    ScheduleSlot.java

  service/
    AuthService.java
    StudentService.java
    ProfessorService.java
    AdminService.java
    CourseService.java
    ComplaintService.java
    GPAService.java
    ValidationService.java

  menu/
    MainMenu.java
    AuthMenu.java
    StudentMenu.java
    ProfessorMenu.java
    AdminMenu.java

  data/
    UniversityDataStore.java
    SeedData.java

  util/
    InputUtil.java
    DisplayUtil.java
    DateUtil.java
    IdGenerator.java
    GradeUtil.java
```

## Final Class Blueprint

## 1. `User` abstract class

### Responsibility

- define all shared user identity information
- provide base authentication support
- enforce role-specific overrides

### Fields

- `String id`
- `String name`
- `String email`
- `String password`
- `String department`

### Methods

- constructor
- getters and setters
- `boolean checkPassword(String inputPassword)`
- `abstract String getRoleName()`
- `abstract void showBasicProfile()`

### OOP Value

- abstraction
- inheritance base
- encapsulation

## 2. `Student extends User`

### Responsibility

- hold student-specific academic identity
- store semester-wise course registration state
- connect student with complaints and progress tracking

### Fields

- `String rollNumber`
- `String admissionNumber`
- `String program`
- `String division`
- `int currentSemester`
- `List<Enrollment> enrollments`
- `List<Complaint> complaints`

### Methods

- constructor
- getters and setters
- `int getCurrentRegisteredCredits()`
- `List<Enrollment> getActiveEnrollments()`
- `List<Enrollment> getCompletedEnrollments()`
- `void addEnrollment(Enrollment enrollment)`
- `void addComplaint(Complaint complaint)`
- `String getRoleName()`
- `void showBasicProfile()`

### OOP Value

- inheritance from `User`
- polymorphism through overrides
- strong data encapsulation

## 3. `Professor extends User`

### Responsibility

- represent faculty records
- maintain specialization and assigned-course mapping

### Fields

- `String facultyId`
- `String specialization`
- `String officeRoom`
- `String officeHours`
- `List<String> assignedCourseCodes`

### Methods

- constructor
- getters and setters
- `void assignCourseCode(String courseCode)`
- `String getRoleName()`
- `void showBasicProfile()`

### OOP Value

- inheritance
- polymorphism
- role specialization

## 4. `Administrator extends User`

### Responsibility

- represent system administrator identity
- support system-level control actions through service layer

### Fields

- `String adminId`
- `String designation`

### Methods

- constructor
- getters and setters
- `String getRoleName()`
- `void showBasicProfile()`

### OOP Value

- clean role inheritance
- clear admin-specific identity

## 5. `Course`

### Responsibility

- represent one course in the academic catalog
- hold course metadata, faculty mapping, prerequisites, and schedule

### Fields

- `String courseCode`
- `String title`
- `int semester`
- `int credits`
- `String scheme`
- `String category`
- `String syllabusSummary`
- `String venue`
- `int enrollmentLimit`
- `Professor assignedProfessor`
- `List<String> prerequisiteCourseCodes`
- `List<ScheduleSlot> scheduleSlots`
- `List<String> enrolledStudentIds`

### Methods

- constructor
- getters and setters
- `void addScheduleSlot(ScheduleSlot slot)`
- `void addPrerequisite(String courseCode)`
- `void addStudent(String studentId)`
- `void removeStudent(String studentId)`
- `boolean isFull()`
- `boolean hasStudent(String studentId)`
- `void displayCourseInfo()`

### OOP Value

- composition with `ScheduleSlot`
- association with `Professor`

## 6. `ScheduleSlot`

### Responsibility

- represent one timetable entry for a course

### Fields

- `String day`
- `String startTime`
- `String endTime`
- `String room`
- `String slotLabel`

### Methods

- constructor
- getters and setters
- `String toDisplayString()`

### OOP Value

- cleaner modeling than storing raw schedule strings

## 7. `Enrollment`

### Responsibility

- represent the relationship between a student and a course
- track registration, completion, drop status, and grade

### Fields

- `String studentId`
- `String courseCode`
- `int semester`
- `String status`
- `String grade`
- `boolean gradeAssigned`

### Allowed Status Values

- `REGISTERED`
- `COMPLETED`
- `DROPPED`

### Methods

- constructor
- getters and setters
- `void markCompleted(String grade)`
- `void markDropped()`
- `boolean isActive()`
- `boolean isCompleted()`

### OOP Value

- avoids weak direct student-course mapping
- keeps academic state well-structured

## 8. `Complaint`

### Responsibility

- represent student grievance records
- support status tracking and admin resolution

### Fields

- `String complaintId`
- `String studentId`
- `String title`
- `String description`
- `String status`
- `String dateRaised`
- `String resolutionDetails`

### Allowed Status Values

- `PENDING`
- `RESOLVED`

### Methods

- constructor
- getters and setters
- `void markResolved(String resolutionDetails)`
- `String toDisplayString()`

### OOP Value

- clean complaint lifecycle model

## Service Layer Freeze

The service layer will hold business logic. Menus will not directly implement complex validation or data mutation logic.

## 1. `AuthService`

### Responsibility

- student signup
- professor signup
- student login
- professor login
- admin login

### Key Methods

- `Student registerStudent(...)`
- `Professor registerProfessor(...)`
- `Student loginStudent(...)`
- `Professor loginProfessor(...)`
- `Administrator loginAdmin(...)`

## 2. `StudentService`

### Responsibility

- student course viewing
- registration
- dropping
- schedule viewing
- progress viewing
- complaint submission

### Key Methods

- `List<Course> viewAvailableCourses(Student student)`
- `boolean registerForCourse(Student student, String courseCode)`
- `boolean dropCourse(Student student, String courseCode)`
- `List<ScheduleSlot> viewSchedule(Student student)`
- `double viewSGPA(Student student, int semester)`
- `double viewCGPA(Student student)`
- `Complaint submitComplaint(Student student, ...)`

## 3. `ProfessorService`

### Responsibility

- assigned course access
- course detail updates
- student list viewing
- grade assignment

### Key Methods

- `List<Course> viewAssignedCourses(Professor professor)`
- `boolean updateCourseDetails(...)`
- `List<Student> viewEnrolledStudents(Professor professor, String courseCode)`
- `boolean assignGrade(Professor professor, String studentId, String courseCode, String grade)`

## 4. `AdminService`

### Responsibility

- catalog management
- student record management
- professor assignment
- complaint resolution

### Key Methods

- `boolean addCourse(Course course)`
- `boolean deleteCourse(String courseCode)`
- `boolean assignProfessorToCourse(String courseCode, String professorId)`
- `List<Student> viewAllStudentRecords()`
- `boolean updateStudentRecord(...)`
- `List<Complaint> viewAllComplaints()`
- `boolean resolveComplaint(String complaintId, String resolutionDetails)`
- `List<Complaint> filterComplaintsByStatus(String status)`
- `List<Complaint> filterComplaintsByDate(String date)`

## 5. `CourseService`

### Responsibility

- course search and listing support
- semester-wise catalog access

### Key Methods

- `List<Course> listAllCourses()`
- `List<Course> listCoursesBySemester(int semester)`
- `Course findCourseByCode(String courseCode)`

## 6. `ComplaintService`

### Responsibility

- complaint creation and retrieval support

### Key Methods

- `Complaint createComplaint(...)`
- `List<Complaint> getStudentComplaints(String studentId)`
- `List<Complaint> getAllComplaints()`

## 7. `GPAService`

### Responsibility

- SGPA calculation
- CGPA calculation
- grade-point conversion

### Key Methods

- `double calculateSGPA(Student student, int semester)`
- `double calculateCGPA(Student student)`
- `int gradeToPoint(String grade)`

## 8. `ValidationService`

### Responsibility

- keep registration and update rules centralized

### Key Methods

- `boolean canRegister(Student student, Course course)`
- `boolean hasCompletedPrerequisites(Student student, Course course)`
- `boolean isCreditLimitExceeded(Student student, Course course)`
- `boolean isAlreadyRegistered(Student student, String courseCode)`
- `boolean canDrop(Student student, String courseCode)`

## Data Layer Freeze

## `UniversityDataStore`

### Responsibility

- act as the in-memory database for the full application

### Fields

- `List<Student> students`
- `List<Professor> professors`
- `List<Administrator> administrators`
- `List<Course> courses`
- `List<Complaint> complaints`

### Key Methods

- `Student findStudentById(String id)`
- `Student findStudentByEmail(String email)`
- `Professor findProfessorById(String id)`
- `Professor findProfessorByEmail(String email)`
- `Administrator findAdminById(String id)`
- `Course findCourseByCode(String courseCode)`
- `Complaint findComplaintById(String complaintId)`

## `SeedData`

### Responsibility

- load realistic SVNIT-based startup records

### Seed Scope

- `63 students`
- `9 professors`
- `1 administrator`
- multi-semester course catalog
- active semester registration data
- selected grades and complaint records for demo realism

## Menu Layer Freeze

## `MainMenu`

### Options

1. Enter Application
2. Exit Application

## `AuthMenu`

### Options

1. Student Login
2. Student Signup
3. Professor Login
4. Professor Signup
5. Administrator Login
6. Back

## `StudentMenu`

### Options

1. View Available Courses
2. Register for Course
3. Drop Course
4. View Weekly Schedule
5. Track Academic Progress
6. Submit Complaint
7. View My Complaints
8. View Profile
9. Logout

## `ProfessorMenu`

### Options

1. View Assigned Courses
2. Update Course Details
3. View Enrolled Students
4. Assign Grades
5. View Profile
6. Logout

## `AdminMenu`

### Options

1. View Course Catalog
2. Add Course
3. Delete Course
4. Assign Professor to Course
5. View Student Records
6. Update Student Records
7. View All Complaints
8. Resolve Complaint
9. Filter Complaints
10. View Profile
11. Logout

## Why This Design Is Correct for Full Marks

- `User` abstraction clearly shows intentional inheritance
- role classes are properly separated
- `Enrollment` avoids weak or messy student-course mapping
- `ScheduleSlot` makes timetable design realistic and clean
- services separate logic from menu code
- menus remain simple and readable
- the model is easy to explain in UML
- the model directly supports all assignment features

## Rejected Alternatives

### Separate unrelated role classes without `User`

- rejected because inheritance and abstraction become weak

### Store schedule as one long string

- rejected because timetable and schedule view become messy

### Store grades directly only in `Student` without `Enrollment`

- rejected because course relationship and status tracking become harder

### Put all logic inside `Main`

- rejected because it weakens OOP structure and becomes difficult to test or explain

## Completion Condition for Step 2

Step 2 is complete when:

- final packages are locked
- final classes are locked
- final fields are locked
- final services are locked
- menu structure is locked
- OOP concept mapping is explicit and explainable

After Step 2, implementation may begin with model classes.
