import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("masukkan angka: ");
        int n = scanner.nextInt();

        System.out.println("output: " + faktorial(n));

        scanner.close();
    }

    public static int faktorial(int n) {
        if (n == 0 || n == 1){
            return 1;
        } else {
            return n * faktorial(n-1);
        }
    }
}
