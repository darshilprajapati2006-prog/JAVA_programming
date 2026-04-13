# AP-2 Implementation Plan

## Current Setup Status

- `AP-1` source code has been copied into this `AP-2` workspace
- project structure is clean and ready for enhancement work
- baseline Java compilation succeeds before AP-2 feature additions

## AP-2 Features To Implement

### 1. Generic Feedback System

- add a generic feedback model for numeric and textual course feedback
- allow students to submit feedback only for completed courses
- allow professors to view feedback for their assigned courses

### 2. Teaching Assistant Role

- introduce `TeachingAssistant` as a subclass of `Student`
- add TA storage, authentication flow, service logic, and menu
- allow TA to assist with viewing/managing grades for assigned courses
- keep professor-only course update privileges restricted

### 3. Robust Exception Handling

- add `CourseFullException`
- add `InvalidLoginException`
- add `DropDeadlinePassedException`
- handle these using `try-catch` blocks in user-facing flows

## Planned Execution Order

1. add AP-2 model and exception classes
2. extend data store and seed data
3. update services for feedback, TA, and exception flow
4. update menus and authentication navigation
5. compile and run demonstration scenarios
6. finalize README and submission notes
