package tuprak5;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Pemanah", 100, 20);
        Wizard wizard = new Wizard("Penyihir", 100, 30);
        Fighter fighter = new Fighter("Petarung", 100, 40);

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan Pilihan: ");
        int karakter = scanner.nextInt();
        System.out.println();

        
        while (karakter < 1 || karakter > 3) {
            System.out.println("Pilihan tidak valid");
            System.out.print("Masukkan Pilihan (1-3): ");
            karakter = scanner.nextInt();
        }

        int hpLawan = 100;

        while (true) {
            System.out.println("\nHP Lawan: " + hpLawan);
            System.out.println("Menu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih Aksi: ");
            int aksi = scanner.nextInt();

            if (aksi < 1 || aksi > 2) {
                System.out.println("Aksi tidak valid");
                continue;
            }

            if (aksi == 2) {
                break;
            }

            if (hpLawan <= 0) {
                System.out.println("Permainan telah selesai. Lawan sudah kalah!");
                break;
            }

            switch (karakter) {
                case 1:
                    archer.Serang();
                    hpLawan -= archer.attackPower;
                    break;
                case 2:
                    wizard.Serang();
                    hpLawan -= wizard.attackPower;
                    break;
                case 3:
                    fighter.SerangLawan();
                    hpLawan -= fighter.attackPower;
                    break;
            }

            // Cek jika lawan sudah kalah setelah serangan
            if (hpLawan <= 0) {
                System.out.println("Lawan kalah!");
                break;
            }
        }

        scanner.close();
    }
}