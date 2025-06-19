import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String judul = input.nextLine();

        String[] Kata = judul.split(" ");
        StringBuilder kapital = new StringBuilder();

        for (String kataa : Kata) {
            if (kataa.length() > 0) {
                kapital.append(Character.toUpperCase(kataa.charAt(0)))
                           .append(kataa.substring(1).toLowerCase())
                           .append(" ");
            }
        }

        System.out.println(kapital);

        input.close();
    }
}
