package OOPs_LAB4;


public class p2 {

    public static boolean isValid(String password) {

        if (password.length() < 5 || password.length() > 12)
            return false;

        boolean hasLower = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch))
                return false;

            if (!Character.isLowerCase(ch) && !Character.isDigit(ch))
                return false;

            if (Character.isLowerCase(ch))
                hasLower = true;

            if (Character.isDigit(ch))
                hasDigit = true;
        }

        if (!hasLower || !hasDigit)
            return false;

        for (int len = 1; len <= password.length() / 2; len++) {
            for (int i = 0; i + 2 * len <= password.length(); i++) {
                String first = password.substring(i, i + len);
                String second = password.substring(i + len, i + 2 * len);
                if (first.equals(second))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String[] tests = {
                "abcanan1",
                "abc11se",
                "123sd123",
                "adfasdsdf",
                "Aasdfasd12"
        };

        for (String pwd : tests) {
            System.out.println(pwd + " -> " + isValid(pwd));
        }
    }
}
