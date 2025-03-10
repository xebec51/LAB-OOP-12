import java.util.*;

public class No5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String pass = input.nextLine();

        boolean True = pass.length() >= 8 && pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$");

        if (True) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        input.close();
    }
}

