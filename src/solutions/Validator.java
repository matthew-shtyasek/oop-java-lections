package solutions;

public class Validator {

    static void checkPassword(String password) throws LengthException, RegisterException, DigitException {
        if (password.length() < 6)
            throw new LengthException();
        if (password.toLowerCase().equals(password) || password.toUpperCase().equals(password))
            throw new RegisterException();
        if (password.replaceAll("[*0-9]", "").equals(password))
            throw new DigitException();
    }

    public static class PasswordException extends Exception {}
    public static class LengthException extends PasswordException {}
    public static class RegisterException extends PasswordException {}
    public static class DigitException extends PasswordException {}
}
