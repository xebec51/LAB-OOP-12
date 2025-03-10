package TUPRAK1;
import java.util.Scanner;

public class NO1 {
    // utk ubah huruf pertama setiap kata jadi kapital
    public static String Kapital(String text) {
        String[] words = text.toLowerCase().split(" "); // split utk memisahkan tiap kata, tolower ubah menjadi huruf kecil
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // ubah huruf pertama (dimulai dari indeks 0) jadi kapital, tpi sisanya tetap kecil
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }
        return result.toString().trim(); // utk hapus spasi yg ada akhir
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //cari tau knpa ad baris kuning

        System.out.print("Masukkan Judul Film: "); // input dri pengguna
        String input = scanner.nextLine();

        String output = Kapital(input);

        System.out.println("Hasil: " + output);
    }
}
