package login_app.utils;

public class StringUtils {
    public static String getNickName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        return parts.length > 1 ? parts[1] : parts[0];
    }
}