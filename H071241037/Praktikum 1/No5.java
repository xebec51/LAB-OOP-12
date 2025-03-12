import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("masukkan password: ");
        String password = scanner.nextLine();

        if(isValidPassword(password)){
            System.out.println("password valid");
        }else {
            System.out.println("password tidak valid");
        }
        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        if(password.length() < 8){
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()){
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }

        return hasUpper && hasLower && hasDigit;
    }
}
