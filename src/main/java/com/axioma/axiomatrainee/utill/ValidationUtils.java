package com.axioma.axiomatrainee.utill;

public class ValidationUtills {

    public static final String USERNAME_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
            + "|\\+7\\d{10}"
            + "|8\\d{10}";
    public static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String PHONE_NUMBER_PATTERN = "\\+7\\d{10}"
            + "|8\\d{10}";

    private ValidationUtils() {
    }

    public static boolean isEmailAddress(String login) {
        return login.matches(EMAIL_PATTERN);
    }
}
