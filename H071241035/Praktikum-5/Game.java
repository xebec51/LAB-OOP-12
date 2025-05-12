package TUGAS_PRAKTIKUM_LAB_5;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // objek
        Hero archer = new Archer("Archer");
        Hero wizard = new Wizard("Wizard");
        Hero fighter = new Fighter("Fighter");

        // pilih chara
        System.out.println("Pilih karakter: ");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");

        System.out.print("Masukkan Pilihan : ");
        int choice = scanner.nextInt();
        Hero PilihHero = null;

        switch (choice) {
            case 1:
                PilihHero = archer;
                break;
            case 2:
                PilihHero = wizard;
                break;
            case 3:
                PilihHero = fighter;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                scanner.close();
                return;
        }

        // menu
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            int action = scanner.nextInt();
            

            if (action == 1) {
                PilihHero.attack(); 
            } else if (action == 2) {
                System.out.println("Game Selesai!");
                break; 
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}

