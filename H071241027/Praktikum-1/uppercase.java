import java.util.Scanner;

public class uppercase{
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("Masukkan Judul FIlm : " );
        String a = x.nextLine();
        x.close();

        System.out.println("Hasil: " +awalbesar(a));
    }                   
    public static String awalbesar (String text) {
        String[] words = text.split(" ");
        String result = "";
        
        for (String word : words) {
            if (!word.isEmpty()) {
                result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
            }
        }
        
        return result.trim();
    }
}