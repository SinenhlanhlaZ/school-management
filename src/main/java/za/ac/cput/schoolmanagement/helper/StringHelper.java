package za.ac.cput.schoolmanagement.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class StringHelper {
    public static boolean isEmptyOrNull(String str) {
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str) {
        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }

    public static void checkObjectParam(String objectName, Object objectValue) {
        if (objectValue == null)
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", objectName));
    }

    public static void isEmailValid(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(email)) throw new IllegalArgumentException("Email is not valid");
    }

public class StringHelper {
}
