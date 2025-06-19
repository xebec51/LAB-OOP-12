import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Hero selectedHero = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih karakter:");
        System.out.println("1. Archer (Pemanah)");
        System.out.println("2. Wizard (Penyihir)");
        System.out.println("3. Fighter (Petarung)");
        System.out.print("Masukkan pilihan : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                selectedHero = new Pemanah("Archer");
                break;
            case 2:
                selectedHero = new Penyihir("Wizard");
                break;
            case 3:
                selectedHero = new Petarung("Fighter");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }
        while (true) {
            System.out.println("\nPilih aksi:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Masukkan pilihan : ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    selectedHero.serang();  // Karakter melakukan serangan
                    break;
                case 2:
                    System.out.println("Keluar dari permainan...");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

    }
}
