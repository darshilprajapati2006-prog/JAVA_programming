package data;

import model.Administrator;
import model.Complaint;
import model.Course;
import model.Enrollment;
import model.Professor;
import model.ScheduleSlot;
import model.Student;

public class SeedData {
    private static final String DEPARTMENT = "Artificial Intelligence";
    private static final String PROGRAM = "Integrated B.Tech + M.Tech in Artificial Intelligence";
    private static final String DIVISION = "A";
    private static final String DEFAULT_STUDENT_PASSWORD = "Student@123";
    private static final String DEFAULT_PROFESSOR_PASSWORD = "Prof@123";
    private static final String DEFAULT_ADMIN_PASSWORD = "Admin@123";

    private static final String[][] STUDENT_ROSTER = {
            {"A01", "I25AI001", "Sahil Devendrakumar Parmar"},
            {"A02", "I25AI002", "Jogdiya Parthiv Kishorbhai"},
            {"A03", "I25AI003", "Prajapati Panklesh"},
            {"A04", "I25AI004", "Damor Krishkumar Dhulabhai"},
            {"A05", "I25AI005", "Rudra Kalpeshkumar Modi"},
            {"A06", "I25AI006", "Kaladhar G A"},
            {"A07", "I25AI007", "Darshil Dilipkumar Prajapati"},
            {"A08", "I25AI008", "Rohit Vaddhya"},
            {"A09", "I25AI009", "Ria Ann Joe"},
            {"A10", "I25AI010", "Chakshey Nakra"},
            {"A11", "I25AI011", "Bharat Lal Pal"},
            {"A12", "I25AI012", "Badva Prince Virji"},
            {"A13", "I25AI013", "Kanishtha Maheshwari"},
            {"A14", "I25AI014", "Stuti Gupta"},
            {"A15", "I25AI015", "Ishan Jain"},
            {"A16", "I25AI016", "Maddipatla Pranathi"},
            {"A17", "I25AI017", "Nagoor Sai Babu"},
            {"A18", "I25AI018", "Nofil Belim"},
            {"A19", "I25AI019", "Reetchheta Mandal"},
            {"A20", "I25AI020", "Sardiya Tilak Yogeshbhai"},
            {"A21", "I25AI021", "Prajapati Nitinbhai Kameshbhai"},
            {"A22", "I25AI022", "Shimpi Meetkumar Pravinhbhai"},
            {"A23", "I25AI023", "Prajapati Nirmal Dineshbhai"},
            {"A24", "I25AI024", "Jalodhra Dhruvit Navanbhai"},
            {"A25", "I25AI025", "Varsh Goindani"},
            {"A26", "I25AI026", "Harshil Purathil"},
            {"A27", "I25AI027", "Bijjam Srithejaa"},
            {"A28", "I25AI028", "Harin Kashyap Mehta"},
            {"A29", "I25AI029", "Chaudhari Dhruva Chetan"},
            {"A30", "I25AI030", "Ayush Kumar"},
            {"A31", "I25AI031", "Gawai Aryan Raju"},
            {"A32", "I25AI032", "Rishu Maurya"},
            {"A33", "I25AI033", "Prajapati Kavya Prakashkumar"},
            {"A34", "I25AI034", "Gawarguru Harshal Satish"},
            {"A35", "I25AI035", "Priya Chaudary"},
            {"A36", "I25AI036", "Naibalwar Atharva Ramrao"},
            {"A37", "I25AI037", "Mishita Gautam Dudhaiya"},
            {"A38", "I25AI038", "Botadara Daksh Visharbhai"},
            {"A39", "I25AI039", "Vadher Yash Vindubhai"},
            {"A40", "I25AI040", "Rakshith"},
            {"A41", "I25AI041", "Prerana Gurudith Kamath"},
            {"A42", "I25AI042", "Mehreen Naaz"},
            {"A43", "I25AI043", "Amit Kumar Singh"},
            {"A44", "I25AI044", "Hanumantu Chaitanya Saketh"},
            {"A45", "I25AI045", "Anshul Jyotish"},
            {"A46", "I25AI046", "Nischal Kavit Kedia"},
            {"A47", "I25AI047", "Nishant Kumar"},
            {"A48", "I25AI048", "Srinidhi Naik"},
            {"A49", "I25AI049", "Burhanuddin"},
            {"A50", "I25AI050", "Devam Garg"},
            {"A51", "I25AI051", "Patrawala Abdultaiyeb Khuzaima"},
            {"A52", "I25AI052", "Sayanthana Sreju"},
            {"A53", "I25AI053", "Mohit Bhama"},
            {"A54", "I25AI054", "Patel Purna Kirankumar"},
            {"A55", "I25AI055", "Jimmy Navinkumar Thakkar"},
            {"A56", "I25AI056", "Helikkumar Kadiya"},
            {"A57", "I25AI057", "Vikash Tiwari"},
            {"A58", "I25AI058", "Anubhav Chaturvedi"},
            {"A59", "I25AI059", "M Manjunath"},
            {"A60", "I25AI060", "Anshika Pipli"},
            {"A61", "I25AI061", "Parmar Hemal Manishbhai"},
            {"A62", "I25AI062", "Vishal"},
            {"A63", "I25AI063", "Chaudhary Adreya Kesharbhai"}
    };

    private static final String[][] PROFESSOR_DATA = {
            {"PROF001", "FAC001", "Dr. Tanmoy Hazra", "hod@aid.svnit.ac.in", "Computer Vision and Biomedical Imaging",
                    "DoAI-201", "Mon-Wed 10:00 AM - 12:00 PM"},
            {"PROF002", "FAC002", "Dr. Rahul Dixit", "rahuldixit@aid.svnit.ac.in", "Machine Learning and NLP",
                    "DoAI-202", "Tue-Thu 11:00 AM - 1:00 PM"},
            {"PROF003", "FAC003", "Dr. Nitesh A. Funde", "nitesh.funde@aid.svnit.ac.in",
                    "Data Analytics and Applied AI", "DoAI-203", "Tue-Fri 2:00 PM - 4:00 PM"},
            {"PROF004", "FAC004", "Dr. Praveen Kumar Chandaliya", "pkc@aid.svnit.ac.in",
                    "Computer Vision and Generative AI", "DoAI-204", "Mon-Wed 3:00 PM - 5:00 PM"},
            {"PROF005", "FAC005", "Dr. Pruthwik Mishra", "pruthwikmishra@aid.svnit.ac.in",
                    "Deep Learning and Optimization", "DoAI-205", "Mon-Thu 1:00 PM - 3:00 PM"},
            {"PROF006", "FAC006", "Dr. Rohit Kumar", "rohitkumar@aid.svnit.ac.in",
                    "Theoretical CS and Digital Systems", "DoAI-206", "Tue-Thu 2:00 PM - 4:00 PM"},
            {"PROF007", "FAC007", "Dr. Rahul Shrivastava", "rahulshrivastava@aid.svnit.ac.in",
                    "Recommender Systems and Machine Learning", "DoAI-207", "Fri 10:00 AM - 12:00 PM"},
            {"PROF008", "FAC008", "Dr. Sankhadeep Chatterjee", "sankhadeep@aid.svnit.ac.in",
                    "Probabilistic AI and Data Mining", "DoAI-208", "Mon-Fri 9:00 AM - 10:00 AM"},
            {"PROF009", "FAC009", "Dr. Sudhakar Mishra", "sudhakarm@aid.svnit.ac.in",
                    "Algorithms and Intelligent Systems", "DoAI-209", "Wed-Fri 11:00 AM - 1:00 PM"}
    };

    private SeedData() {
    }

    public static String getDemoSummary() {
        return """
                Demo Data Loaded:
                - Students seeded: 63
                - Professors seeded: 9
                - Administrators seeded: 1
                - Courses seeded: 53
                - Complaints seeded: 8

                Recommended Demo Accounts:
                - Student Success Demo:
                  Email: i25ai001@students.aid.svnit.ac.in
                  Password: Student@123
                - Student Prerequisite Block Demo:
                  Email: i25ai005@students.aid.svnit.ac.in
                  Password: Student@123
                - Professor Demo:
                  Email: rahulshrivastava@aid.svnit.ac.in
                  Password: Prof@123
                - Admin Demo:
                  ID: ADMIN01
                  Password: Admin@123
                """;
    }

    public static void initialize(UniversityDataStore dataStore) {
        dataStore.clearAll();
        seedProfessors(dataStore);
        seedAllStudents(dataStore);
        seedAdministrator(dataStore);
        seedCoursesBySemester(dataStore);
        seedEnrollmentsAndGrades(dataStore);
        seedComplaints(dataStore);
    }

    private static void seedProfessors(UniversityDataStore dataStore) {
        for (String[] professorData : PROFESSOR_DATA) {
            Professor professor = new Professor(
                    professorData[0],
                    professorData[2],
                    professorData[3],
                    DEFAULT_PROFESSOR_PASSWORD,
                    DEPARTMENT,
                    professorData[1],
                    professorData[4],
                    professorData[5],
                    professorData[6]);
            dataStore.addProfessor(professor);
        }
    }

    private static void seedAllStudents(UniversityDataStore dataStore) {
        for (int index = 0; index < STUDENT_ROSTER.length; index++) {
            String[] studentData = STUDENT_ROSTER[index];
            String studentId = String.format("STU%03d", index + 1);
            String email = studentData[1].toLowerCase() + "@students.aid.svnit.ac.in";
            Student student = new Student(
                    studentId,
                    studentData[2],
                    email,
                    DEFAULT_STUDENT_PASSWORD,
                    DEPARTMENT,
                    studentData[0],
                    studentData[1],
                    PROGRAM,
                    DIVISION,
                    2);
            dataStore.addStudent(student);
        }
    }

    private static void seedAdministrator(UniversityDataStore dataStore) {
        dataStore.addAdministrator(new Administrator(
                "ADMIN01",
                "Academic Admin",
                "admin@aid.svnit.ac.in",
                DEFAULT_ADMIN_PASSWORD,
                DEPARTMENT,
                "ADMIN01",
                "Academic Administration",
                DEFAULT_ADMIN_PASSWORD));
    }

    private static void seedCoursesBySemester(UniversityDataStore dataStore) {
        addCourse(dataStore, course("IA101", "Introduction to Artificial Intelligence", "Department Faculty", 4, 1,
                "DoAI-101", "Foundations of computing and AI-oriented problem solving.", 70),
                slot("Monday", "8:30 AM", "9:20 AM", "DoAI-101", "A"),
                slot("Thursday", "9:30 AM", "10:20 AM", "DoAI-101", "D"));

        addCourse(dataStore, course("MA105", "Calculus and Linear Algebra", "Mathematics Department", 4, 1,
                "DoAI-102", "Calculus, matrices, determinants and vector spaces.", 70),
                slot("Tuesday", "8:30 AM", "9:20 AM", "DoAI-102", "B"),
                slot("Friday", "8:30 AM", "9:20 AM", "DoAI-102", "F"));

        addCourse(dataStore, course("MA116", "Semester 1 Curriculum Course MA116", "Mathematics Department", 2, 1,
                "DoAI-102", "Official curriculum support course from the IPG AI semester 1 scheme.", 70),
                slot("Wednesday", "2:00 PM", "2:50 PM", "DoAI-102", "K"));

        addCourse(dataStore, course("HS110", "Semester 1 Curriculum Course HS110", "Humanities Department", 2, 1,
                "DoAI-103", "Communication, values and professional orientation.", 70),
                slot("Thursday", "2:00 PM", "2:50 PM", "DoAI-103", "L"));

        addCourse(dataStore, course("EE103", "Semester 1 Curriculum Course EE103", "Electrical Engineering Department", 4, 1,
                "DoAI-104", "Basic electrical engineering concepts for first year IPG students.", 70),
                slot("Friday", "10:30 AM", "11:20 AM", "DoAI-104", "M"));

        Course ia102 = course("IA102", "Data Structures", "Dr. Rahul Shrivastava", 5, 2,
                "DoAI-106", "Arrays, linked lists, stacks, queues, trees and graphs.", 60);
        addCourse(dataStore, ia102,
                slot("Monday", "9:30 AM", "10:20 AM", "DoAI-106", "A"),
                slot("Wednesday", "8:30 AM", "9:20 AM", "DoAI-106", "D"));

        Course ia104 = course("IA104", "Web Programming and Python", "Dr. Praveen Kumar Chandaliya", 4, 2,
                "DoAI-108", "HTML, CSS, Python basics and web application fundamentals.", 60);
        ia104.addPrerequisite("IA101");
        addCourse(dataStore, ia104,
                slot("Tuesday", "11:30 AM", "12:20 PM", "DoAI-108", "B"),
                slot("Friday", "2:00 PM", "2:50 PM", "DoAI-108", "P"));

        addCourse(dataStore, course("EG110", "Energy and Environmental Engineering", "Department Faculty", 4, 2,
                "DoAI-106", "Energy systems, sustainability and environmental concepts.", 70),
                slot("Thursday", "10:30 AM", "11:20 AM", "DoAI-106", "E"));

        addCourse(dataStore, course("MA106", "Discrete Mathematics", "Mathematics Department", 4, 2,
                "DoAI-106", "Logic, relations, combinatorics, graphs and recurrence relations.", 70),
                slot("Friday", "3:00 PM", "3:50 PM", "DoAI-106", "F"));

        addCourse(dataStore, course("EC106", "Digital Electronics and Logic Design", "Dr. Rohit Kumar", 4, 2,
                "DoAI-110", "Boolean algebra, logic gates, combinational and sequential circuits.", 65),
                slot("Wednesday", "3:00 PM", "3:50 PM", "DoAI-110", "G"));

        addCourse(dataStore, course("HS120", "Indian Value System and Social Consciousness", "Humanities Department", 2, 2,
                "DoAI-106", "Ethics, constitutional values, society and professional responsibility.", 70),
                slot("Tuesday", "10:30 AM", "11:20 AM", "DoAI-106", "C"));

        addCourse(dataStore, course("IA201", "Integrated AI Curriculum Course IA201", "Dr. Tanmoy Hazra", 4, 3,
                "DoAI-201", "Semester 3 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA203", "Integrated AI Curriculum Course IA203", "Dr. Rahul Dixit", 4, 3,
                "DoAI-202", "Semester 3 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA205", "Integrated AI Curriculum Course IA205", "Dr. Nitesh A. Funde", 4, 3,
                "DoAI-203", "Semester 3 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("EC205", "Integrated AI Curriculum Course EC205", "Dr. Rohit Kumar", 4, 3,
                "DoAI-206", "Semester 3 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA209", "Integrated AI Curriculum Course IA209", "Dr. Rahul Shrivastava", 4, 3,
                "DoAI-207", "Semester 3 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA211", "Integrated AI Curriculum Course IA211", "Dr. Sankhadeep Chatterjee", 2, 3,
                "DoAI-208", "Semester 3 official IPG AI curriculum course.", 65));

        addCourse(dataStore, course("IA202", "Integrated AI Curriculum Course IA202", "Dr. Tanmoy Hazra", 4, 4,
                "DoAI-201", "Semester 4 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA204", "Integrated AI Curriculum Course IA204", "Dr. Rahul Dixit", 4, 4,
                "DoAI-202", "Semester 4 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA206", "Integrated AI Curriculum Course IA206", "Dr. Nitesh A. Funde", 4, 4,
                "DoAI-203", "Semester 4 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA208", "Integrated AI Curriculum Course IA208", "Dr. Pruthwik Mishra", 4, 4,
                "DoAI-205", "Semester 4 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA210", "Integrated AI Curriculum Course IA210", "Dr. Rahul Shrivastava", 4, 4,
                "DoAI-207", "Semester 4 official IPG AI curriculum course.", 65));
        addCourse(dataStore, course("IA212", "Integrated AI Curriculum Course IA212", "Dr. Sudhakar Mishra", 2, 4,
                "DoAI-209", "Semester 4 official IPG AI curriculum course.", 65));

        addCourse(dataStore, course("IA301", "Integrated AI Curriculum Course IA301", "Dr. Tanmoy Hazra", 4, 5,
                "DoAI-201", "Semester 5 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA303", "Integrated AI Curriculum Course IA303", "Dr. Rahul Dixit", 4, 5,
                "DoAI-202", "Semester 5 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA305", "Integrated AI Curriculum Course IA305", "Dr. Nitesh A. Funde", 4, 5,
                "DoAI-203", "Semester 5 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA3AA", "Integrated AI Curriculum Course IA3AA", "Dr. Praveen Kumar Chandaliya", 4, 5,
                "DoAI-204", "Semester 5 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA3BB", "Integrated AI Curriculum Course IA3BB", "Dr. Pruthwik Mishra", 4, 5,
                "DoAI-205", "Semester 5 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA307", "Integrated AI Curriculum Course IA307", "Dr. Rohit Kumar", 2, 5,
                "DoAI-206", "Semester 5 official IPG AI curriculum course.", 60));

        addCourse(dataStore, course("IA302", "Integrated AI Curriculum Course IA302", "Dr. Tanmoy Hazra", 4, 6,
                "DoAI-201", "Semester 6 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA304", "Integrated AI Curriculum Course IA304", "Dr. Rahul Dixit", 4, 6,
                "DoAI-202", "Semester 6 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA306", "Integrated AI Curriculum Course IA306", "Dr. Nitesh A. Funde", 4, 6,
                "DoAI-203", "Semester 6 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA3DD", "Integrated AI Curriculum Course IA3DD", "Dr. Praveen Kumar Chandaliya", 4, 6,
                "DoAI-204", "Semester 6 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA3EE", "Integrated AI Curriculum Course IA3EE", "Dr. Pruthwik Mishra", 4, 6,
                "DoAI-205", "Semester 6 official IPG AI curriculum course.", 60));
        addCourse(dataStore, course("IA308", "Integrated AI Curriculum Course IA308", "Dr. Sudhakar Mishra", 2, 6,
                "DoAI-209", "Semester 6 official IPG AI curriculum course.", 60));

        addCourse(dataStore, course("IA401", "Integrated AI Curriculum Course IA401", "Dr. Tanmoy Hazra", 4, 7,
                "DoAI-201", "Semester 7 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA403", "Integrated AI Curriculum Course IA403", "Dr. Rahul Dixit", 4, 7,
                "DoAI-202", "Semester 7 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA405", "Integrated AI Curriculum Course IA405", "Dr. Nitesh A. Funde", 4, 7,
                "DoAI-203", "Semester 7 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA4BB", "Integrated AI Curriculum Course IA4BB", "Dr. Praveen Kumar Chandaliya", 4, 7,
                "DoAI-204", "Semester 7 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA4CC", "Integrated AI Curriculum Course IA4CC", "Dr. Pruthwik Mishra", 4, 7,
                "DoAI-205", "Semester 7 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA4DD", "Integrated AI Curriculum Course IA4DD", "Dr. Rahul Shrivastava", 4, 7,
                "DoAI-207", "Semester 7 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA407", "Integrated AI Curriculum Course IA407", "Dr. Sankhadeep Chatterjee", 2, 7,
                "DoAI-208", "Semester 7 official IPG AI curriculum course.", 55));

        addCourse(dataStore, course("IA402", "Integrated AI Curriculum Course IA402", "Dr. Tanmoy Hazra", 4, 8,
                "DoAI-201", "Semester 8 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("HUXXX", "Integrated AI Curriculum Course HUXXX", "Humanities Department", 2, 8,
                "DoAI-103", "Semester 8 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA404", "Integrated AI Curriculum Course IA404", "Dr. Rahul Dixit", 4, 8,
                "DoAI-202", "Semester 8 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA406", "Integrated AI Curriculum Course IA406", "Dr. Nitesh A. Funde", 4, 8,
                "DoAI-203", "Semester 8 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA408", "Integrated AI Curriculum Course IA408", "Dr. Praveen Kumar Chandaliya", 4, 8,
                "DoAI-204", "Semester 8 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA410", "Integrated AI Curriculum Course IA410", "Dr. Rahul Shrivastava", 4, 8,
                "DoAI-207", "Semester 8 official IPG AI curriculum course.", 55));
        addCourse(dataStore, course("IA412", "Integrated AI Curriculum Course IA412", "Dr. Sudhakar Mishra", 2, 8,
                "DoAI-209", "Semester 8 official IPG AI curriculum course.", 55));

        addCourse(dataStore, course("IA501", "Integrated AI Curriculum Course IA501", "Dr. Tanmoy Hazra", 10, 9,
                "DoAI-301", "Semester 9 official IPG AI curriculum course.", 30));
        addCourse(dataStore, course("IA503", "Integrated AI Curriculum Course IA503", "Dr. Rahul Dixit", 10, 9,
                "DoAI-302", "Semester 9 official IPG AI curriculum course.", 30));
        addCourse(dataStore, course("IA505", "Integrated AI Curriculum Course IA505", "Dr. Sudhakar Mishra", 10, 9,
                "DoAI-303", "Semester 9 official IPG AI curriculum course.", 30));
        addCourse(dataStore, course("IA502", "Integrated AI Curriculum Course IA502", "Dr. Tanmoy Hazra", 20, 10,
                "DoAI-401", "Semester 10 official IPG AI curriculum course.", 20));

        assignProfessor(dataStore, "PROF004", "IA104", "IA3AA", "IA3DD", "IA408");
        assignProfessor(dataStore, "PROF006", "EC106", "EC205", "IA307");
        assignProfessor(dataStore, "PROF007", "IA102", "IA209", "IA210", "IA4DD", "IA410");
        assignProfessor(dataStore, "PROF001", "IA201", "IA202", "IA301", "IA302", "IA401", "IA402", "IA501", "IA502");
        assignProfessor(dataStore, "PROF002", "IA203", "IA204", "IA303", "IA304", "IA403", "IA404", "IA503");
        assignProfessor(dataStore, "PROF003", "IA205", "IA206", "IA305", "IA306", "IA405", "IA406");
        assignProfessor(dataStore, "PROF005", "IA208", "IA3BB", "IA3EE", "IA4CC");
        assignProfessor(dataStore, "PROF008", "IA211", "IA407");
        assignProfessor(dataStore, "PROF009", "IA212", "IA308", "IA412", "IA505");
    }

    private static void seedEnrollmentsAndGrades(UniversityDataStore dataStore) {
        for (int index = 1; index <= 63; index++) {
            Student student = dataStore.findStudentById(String.format("STU%03d", index));
            if (student == null) {
                continue;
            }

            seedCompletedCourse(student, "MA105", 1, gradeByIndex(index, 0));
            seedCompletedCourse(student, "MA116", 1, gradeByIndex(index, 1));
            seedCompletedCourse(student, "HS110", 1, gradeByIndex(index, 2));
            seedCompletedCourse(student, "EE103", 1, gradeByIndex(index, 3));

            if (!isPrerequisiteBlockedStudent(index)) {
                seedCompletedCourse(student, "IA101", 1, gradeByIndex(index, 4));
            }

            if (index % 3 == 1) {
                registerSeedCourse(dataStore, student, "IA102");
                registerSeedCourse(dataStore, student, "MA106");
            } else if (index % 3 == 2) {
                if (!isPrerequisiteBlockedStudent(index)) {
                    registerSeedCourse(dataStore, student, "IA104");
                } else {
                    registerSeedCourse(dataStore, student, "EG110");
                }
                registerSeedCourse(dataStore, student, "HS120");
            } else {
                registerSeedCourse(dataStore, student, "EC106");
                registerSeedCourse(dataStore, student, "EG110");
            }
        }

        Student creditEdgeCaseStudent = dataStore.findStudentById("STU004");
        if (creditEdgeCaseStudent != null) {
            registerSeedCourse(dataStore, creditEdgeCaseStudent, "IA102");
            registerSeedCourse(dataStore, creditEdgeCaseStudent, "IA104");
            registerSeedCourse(dataStore, creditEdgeCaseStudent, "EG110");
            registerSeedCourse(dataStore, creditEdgeCaseStudent, "MA106");
            registerSeedCourse(dataStore, creditEdgeCaseStudent, "HS120");
        }

        Student complaintDemoStudent = dataStore.findStudentById("STU001");
        if (complaintDemoStudent != null) {
            registerSeedCourse(dataStore, complaintDemoStudent, "IA102");
            registerSeedCourse(dataStore, complaintDemoStudent, "MA106");
        }

        Student resolvedCaseStudent = dataStore.findStudentById("STU002");
        if (resolvedCaseStudent != null) {
            registerSeedCourse(dataStore, resolvedCaseStudent, "IA104");
            registerSeedCourse(dataStore, resolvedCaseStudent, "HS120");
        }

        Student professorViewCaseStudent = dataStore.findStudentById("STU003");
        if (professorViewCaseStudent != null) {
            registerSeedCourse(dataStore, professorViewCaseStudent, "EC106");
        }

        Student darshil = dataStore.findStudentById("STU007");
        if (darshil != null) {
            darshil.setReportedSgpa(1, 7.70);
            darshil.setReportedCgpa(7.70);
        }
    }

    private static void seedComplaints(UniversityDataStore dataStore) {
        addComplaint(dataStore, "CMP001", "STU001",
                "Timetable Clash",
                "Timetable clash between IA102 schedule and another academic activity.",
                "PENDING",
                "2026-04-01",
                "");

        addComplaint(dataStore, "CMP002", "STU002",
                "Professor Visibility Issue",
                "Assigned professor information was not visible for IA104 on the portal.",
                "RESOLVED",
                "2026-03-30",
                "Professor assignment synced and displayed on the portal.");

        addComplaint(dataStore, "CMP003", "STU005",
                "Prerequisite Record Issue",
                "Unable to register in IA104 because prerequisite record appears incomplete.",
                "PENDING",
                "2026-04-02",
                "");

        addComplaint(dataStore, "CMP004", "STU012",
                "Venue Mismatch",
                "Course venue mismatch between schedule and classroom notice.",
                "RESOLVED",
                "2026-03-29",
                "Venue corrected to DoAI-110 and updated in the system.");

        addComplaint(dataStore, "CMP005", "STU018",
                "Enrollment Count Error",
                "Portal shows duplicate enrollment count for EC106.",
                "PENDING",
                "2026-04-03",
                "");

        addComplaint(dataStore, "CMP006", "STU027",
                "Complaint Status Visibility",
                "Unable to view complaint status after submission.",
                "RESOLVED",
                "2026-03-28",
                "Student dashboard complaint listing refreshed successfully.");

        addComplaint(dataStore, "CMP007", "STU041",
                "Credit Limit Clarification",
                "Credit limit clarification needed before additional registration.",
                "PENDING",
                "2026-04-04",
                "");

        addComplaint(dataStore, "CMP008", "STU055",
                "Office Hours Update",
                "Professor office hours appear outdated in the portal.",
                "RESOLVED",
                "2026-03-27",
                "Office hours updated by academic admin after faculty confirmation.");
    }

    private static Course course(
            String code,
            String title,
            String professor,
            int credits,
            int semester,
            String location,
            String syllabus,
            int limit) {
        return new Course(code, title, professor, credits, location, syllabus, limit, semester);
    }

    private static ScheduleSlot slot(String day, String start, String end, String room, String label) {
        return new ScheduleSlot(day, start, end, room, label);
    }

    private static void addCourse(UniversityDataStore dataStore, Course course, ScheduleSlot... slots) {
        for (ScheduleSlot slot : slots) {
            course.addTiming(slot);
        }
        dataStore.addCourse(course);
    }

    private static void assignProfessor(UniversityDataStore dataStore, String professorId, String... courseCodes) {
        Professor professor = dataStore.findProfessorById(professorId);
        if (professor == null) {
            return;
        }

        for (String courseCode : courseCodes) {
            Course course = dataStore.findCourseByCode(courseCode);
            if (course != null) {
                course.setProfessor(professor.getName());
                professor.assignCourse(courseCode);
            }
        }
    }

    private static void seedCompletedCourse(Student student, String courseCode, int semester, String grade) {
        Enrollment enrollment = new Enrollment(student.getId(), courseCode, semester);
        enrollment.markCompleted(grade);
        student.addEnrollment(enrollment);
        student.addCompletedCourse(courseCode);
        student.addGrade(grade);
    }

    private static void registerSeedCourse(UniversityDataStore dataStore, Student student, String courseCode) {
        Course course = dataStore.findCourseByCode(courseCode);
        if (student == null || course == null) {
            return;
        }

        if (student.findEnrollment(courseCode) != null) {
            return;
        }

        if (course.addStudent(student.getId())) {
            student.addRegisteredCourse(courseCode);
            student.addEnrollment(new Enrollment(student.getId(), courseCode, student.getCurrentSemester()));
        }
    }

    private static void addComplaint(
            UniversityDataStore dataStore,
            String complaintId,
            String studentId,
            String title,
            String description,
            String status,
            String date,
            String resolutionDetails) {
        Student student = dataStore.findStudentById(studentId);
        String studentName = student != null ? student.getName() : "Unknown Student";
        Complaint complaint = new Complaint(
                complaintId,
                studentId,
                studentName,
                title,
                description,
                status,
                date,
                resolutionDetails);
        dataStore.addComplaint(complaint);
        if (student != null) {
            student.addComplaint(complaint);
        }
    }

    private static boolean isPrerequisiteBlockedStudent(int index) {
        return index == 5 || index == 11 || index == 19 || index == 28 || index == 41;
    }

    private static String gradeByIndex(int studentIndex, int offset) {
        String[] grades = {"AA", "AB", "BB", "BC", "CC", "CD", "DD"};
        return grades[(studentIndex + offset) % grades.length];
    }
}
