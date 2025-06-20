import java.util.Scanner;

public class pass {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = x.nextLine();

        if (passbenar(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        x.close();
    }

    public static boolean passbenar(String password) {
        if (password.length() < 8) return false;

        boolean adaBesar = false;
        boolean adaKecil = false;
        boolean adaAngka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) adaBesar = true;
            if (Character.isLowerCase(c)) adaKecil = true;
            if (Character.isDigit(c)) adaAngka = true;
        }

        return adaBesar && adaKecil && adaAngka;
    }
}