package TUPRAK1;
import java.util.Scanner;

public class NO2 {
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Masukkan angka yang ingin dicari: ");
            int cari = input.nextInt();
            boolean ditemukan = false;
            // looping utk cari angka
            for (int baris = 0; baris < nums.length; baris++) {
                for (int kolom = 0; kolom < nums[baris].length; kolom++) {
                    if (nums[baris][kolom] == cari) {
                        System.out.println("Found " + cari + " at [" + baris + "][" + kolom + "]");
                        ditemukan = true;
                        break; // keluar dri loop kolom
                    }
                }
                if (ditemukan) {
                    break; // keluar dri loop baris kl sdh ketemu
                }
            }

            if (!ditemukan) {
                System.out.println("Angka " + cari + " tidak ditemukan dalam array.");
            }

        } catch (Exception e) {
            System.out.println("Input harus berupa angka!");
        }
        input.close();
    }
}
