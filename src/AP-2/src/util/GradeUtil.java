package util;

public class GradeUtil {
    private GradeUtil() {
    }

    public static int getGradePoint(String grade) {
        if (grade == null) {
            return -1;
        }

        switch (grade.trim().toUpperCase()) {
            case "AA":
            case "A":
                return 10;
            case "AB":
                return 9;
            case "BB":
            case "B":
                return 8;
            case "BC":
                return 7;
            case "CC":
            case "C":
                return 6;
            case "CD":
                return 5;
            case "DD":
            case "D":
                return 4;
            case "FF":
            case "F":
                return 0;
            default:
                return -1;
        }
    }

    public static boolean isValidLetterGrade(String grade) {
        return getGradePoint(grade) >= 0;
    }

    public static boolean isPassingGrade(String grade) {
        int gradePoint = getGradePoint(grade);
        return gradePoint >= 4;
    }
}
