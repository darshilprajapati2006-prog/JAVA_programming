# UML Draft

This file contains the draft UML for the `SVNIT Course Registration System`.

## Class Diagram

```mermaid
classDiagram
    class User {
        <<abstract>>
        -String id
        -String name
        -String email
        -String password
        -String department
        +checkPassword(inputPassword) boolean
        +getRoleName() String
        +showBasicProfile() String
    }

    class Student {
        -String rollNumber
        -String admissionNumber
        -String program
        -String division
        -int currentSemester
        -List~String~ completedCourses
        -List~String~ registeredCourses
        -List~String~ grades
        -List~Complaint~ complaints
        -List~Enrollment~ enrollments
        +addEnrollment(enrollment)
        +addComplaint(complaint)
        +getActiveEnrollments() List~Enrollment~
        +getCompletedEnrollments() List~Enrollment~
    }

    class Professor {
        -String facultyId
        -String expertise
        -List~String~ assignedCourses
        -String officeRoom
        -String officeHours
        +assignCourse(courseCode)
        +removeAssignedCourse(courseCode)
    }

    class Administrator {
        -String adminId
        -String designation
        -String fixedPassword
        +validateFixedPassword(inputPassword) boolean
    }

    class Course {
        -String courseCode
        -String title
        -String professor
        -int credits
        -List~String~ prerequisites
        -List~ScheduleSlot~ timings
        -String location
        -String syllabus
        -int enrollmentLimit
        -List~String~ enrolledStudents
        -int semester
        +addPrerequisite(courseCode)
        +addTiming(slot)
        +addStudent(studentId) boolean
        +removeStudent(studentId) boolean
        +isFull() boolean
        +displayCourseInfo() String
    }

    class Enrollment {
        -String studentId
        -String courseCode
        -int semester
        -String grade
        -String status
        +markCompleted(grade)
        +markDropped()
        +isCompleted() boolean
        +isActive() boolean
    }

    class Complaint {
        -String complaintId
        -String studentId
        -String studentName
        -String title
        -String description
        -String status
        -String dateRaised
        -String resolutionNote
        +markResolved(resolutionDetails)
        +displayComplaint() String
    }

    class ScheduleSlot {
        -String day
        -String startTime
        -String endTime
        -String room
        -String slotLabel
        +toDisplayString() String
    }

    class AdminService {
        +viewAllCourses()
        +addCourse(course)
        +deleteCourse(courseCode)
        +assignProfessorToCourse(courseCode, professorId)
        +updateStudentRecord(...)
        +updateComplaintStatus(complaintId, resolutionDetails)
    }

    User <|-- Student
    User <|-- Professor
    User <|-- Administrator

    Student "1" *-- "0..*" Enrollment : maintains
    Student "1" *-- "0..*" Complaint : submits
    Course "1" *-- "0..*" ScheduleSlot : contains

    Student "1" --> "0..*" Course : registers for
    Professor "1" --> "0..*" Course : manages/updates
    Administrator "1" --> "0..*" Complaint : resolves
    Administrator "1" --> "0..*" Student : manages records
    Administrator "1" --> "0..*" Course : manages catalog
```

## What This UML Covers

- `User` as the abstract base class
- `Student`, `Professor`, and `Administrator` inheritance
- student-to-course relationship through registration/enrollment
- student-to-complaint relationship
- course-to-professor management relationship
- admin control over course records, student records, and complaints
- course composition with timetable slots

## Why This Matches The Assignment

- abstraction is visible through `User`
- inheritance is visible through role subclasses
- encapsulation is reflected through modeled private fields
- polymorphism is reflected through shared role methods
- role separation is visible:
  - student registers and complains
  - professor reads/updates assigned courses only
  - admin manages catalog, records, and complaints

## Final Submission Note

This draft can later be:

- redrawn in a diagram tool
- converted to a hand-drawn UML
- converted to a cleaner final notation for submission

But the structure should remain the same as the implemented code.
