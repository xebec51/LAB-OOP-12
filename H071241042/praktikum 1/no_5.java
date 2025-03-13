import java.util.Scanner;

public class no_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (validasiPassword(password)) {
            System.out.println("Output : Password valid");
        } else {
            System.out.println("Output : Password tidak valid");
        }
        scanner.close();
    }

    public static boolean validasiPassword(String password) {
        if (password.length() < 8) {
            return false; // Minimal 8 karakter
        }

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(c)) {
                adaAngka = true;
            }
        }

        return adaHurufBesar && adaHurufKecil && adaAngka; // Memastikan semua syarat terpenuhi
    }
}