# AP-2 Demonstration Guide

This file provides ready demonstration examples for the AP-2 enhancements required in the assignment.

## Demo 1: Generic Feedback System

Goal:
- show generic programming using numeric and textual course feedback
- show professor-side feedback visibility

Steps:
1. Login as student
   Email: `i25ai001@students.aid.svnit.ac.in`
   Password: `Student@123`
2. Choose `Give Numeric Feedback`
3. Enter course code: `IA101`
4. Enter rating: `5`
5. Choose `Give Text Feedback`
6. Enter course code: `IA101`
7. Enter comment: `Great course for AI basics`
8. Logout
9. Login as professor
   Email: `rahulshrivastava@aid.svnit.ac.in`
   Password: `Prof@123`
10. Choose `View Course Feedback`
11. Enter course code: `IA101`

Expected result:
- numeric and text feedback are accepted only because `IA101` is completed
- professor can view both feedback entries

## Demo 2: Teaching Assistant Functionality

Goal:
- show that TA inherits student capabilities
- show TA-specific grading assistance
- show TA does not have professor course-update privileges

Steps:
1. Login as TA
   Email: `ta001@students.aid.svnit.ac.in`
   Password: `TA@123`
2. Show normal student options in TA dashboard:
   - view available courses
   - view weekly schedule
   - track academic progress
3. Choose `View Assigned TA Courses`
4. Enter or show assigned course: `IA102`
5. Choose `View Students For Grade Management`
6. Enter course code: `IA102`
7. Choose `Manage Student Grades`
8. Enter course code: `IA102`
9. Enter student ID: `STU001`
10. Enter grade: `AA`

Expected result:
- TA dashboard contains inherited student features
- TA can manage grades only for assigned courses
- TA does not get professor course-detail update options

## Demo 3: Invalid Login Exception

Goal:
- show `InvalidLoginException`

Steps:
1. Go to student login
2. Enter email: `i25ai001@students.aid.svnit.ac.in`
3. Enter wrong password: `wrongpass`

Expected result:
- system shows invalid login message through caught custom exception

## Demo 4: Course Full Exception

Goal:
- show `CourseFullException`

Steps:
1. Login as student
   Email: `i25ai002@students.aid.svnit.ac.in`
   Password: `Student@123`
2. Choose `Register for Course`
3. Enter course code: `IA102`

Expected result:
- system throws and handles full-course exception
- message indicates that enrollment limit has been reached

## Demo 5: Drop Deadline Passed Exception

Goal:
- show `DropDeadlinePassedException`

Steps:
1. Login as student
   Email: `i25ai001@students.aid.svnit.ac.in`
   Password: `Student@123`
2. Choose `Drop Course`
3. Enter course code: `IA102`

Expected result:
- system throws and handles drop-deadline exception
- message indicates that the drop deadline has already passed

## Quick Demo Order For Viva

1. Invalid login exception
2. Full course exception
3. Drop deadline exception
4. Student feedback submission
5. Professor feedback viewing
6. TA login and grade assistance
