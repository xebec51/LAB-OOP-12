import java.util.Scanner;
public class Main {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while(running){
            System.out.println("===Pilih Karakter===");
            System.out.println("1. Archer(pemanah)");
            System.out.println("2. Wizard(penyirih)");
            System.out.println("3. Fighter(petarung)");
            System.out.println("4. Keluar");
            System.out.println("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            Hero hero = null;

            switch (pilihan){
                case 1:
                    hero = new Archer("Archer", 80, 25);
                break;
                case 2:
                    hero = new Wizard("Wizard", 50, 30);
                break;
                case 3:
                    hero = new Fighter();
                break;
                case 4:
                    running = false;
                    System.out.println("Program berakhir");
                default:
                System.out.println("Pilihan tdk valid, coba lagi");
                continue;
            }
            if (hero != null){
                hero.serang();
            }
            System.out.println();
        }
        scanner.close();
   } 
}
