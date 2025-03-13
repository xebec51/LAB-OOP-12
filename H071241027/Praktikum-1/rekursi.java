import java.util.Scanner;

public class rekursi {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Input : ");
        int n = x.nextInt();

        int result = factorial(n);

        System.out.println("Output: " + result);

        x.close();
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}