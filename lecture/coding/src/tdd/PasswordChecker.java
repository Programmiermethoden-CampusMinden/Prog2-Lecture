package tdd;

public class PasswordChecker {
    public static boolean isValid(String pw) {
        if (pw == null) {
            return false;
        }
        return !pw.isEmpty() && pw.length() > 3 && pw.length() <= 10;
    }
}
