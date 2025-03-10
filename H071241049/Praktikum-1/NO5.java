package TUPRAK1;
import java.util.Scanner;

public class NO5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        if (PasswordValid(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        input.close();
    }
    //untuk cek password valid atau tdk
    public static boolean PasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean angka = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) { //utk cek jika ad huruf besar
                hurufBesar = true;
            } else if (Character.isLowerCase(c)) { //utk cek jika ad huruf kecil
                hurufKecil = true;
            } else if (Character.isDigit(c)) { //utk cek jika ad angka
                angka = true;
            }
        }
        return hurufBesar && hurufKecil && angka;
    }
}

