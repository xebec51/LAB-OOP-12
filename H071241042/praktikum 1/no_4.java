import java.util.Scanner;

public class no_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        int n = scanner.nextInt();
        int hasil = faktorial(n);
        System.out.println("Output : " + hasil);
        scanner.close();
    }

    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Basis rekursi
        }
        return n * faktorial(n - 1); // Rekursi
    }
}