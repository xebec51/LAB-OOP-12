import java.util.Scanner;

public class no_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String input = scanner.nextLine();
        String output = ubahkakata(input);
        System.out.println(output);
        scanner.close();
    }

    public static String ubahkakata(String kalimat) {
        String[] kata = kalimat.split(" ");
        StringBuilder hasilakhir = new StringBuilder();

        for (String word : kata) {
            if (word.length() > 0) {
                hasilakhir.append(Character.toUpperCase(word.charAt(0)));
                hasilakhir.append(word.substring(1).toLowerCase());
                hasilakhir.append(" ");
            } else  {
                System.out.println("Input tidak valid");
            }
        }
        return hasilakhir.toString().trim(); // Kembalikan hasil tanpa spasi ekstra
    }
}