import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka yang dicari: ");
            int target = scanner.nextInt();

            boolean ditemukan = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break; 
                    }
                }
                if (ditemukan) break;
            }

            if (!ditemukan) {
                System.out.println(target + " tidak ditemukan dalam array.");
            }

        } catch (Exception e) {
            System.out.println("Input harus berupa bilangan bulat!");
        } finally {
            scanner.close();
        }
    }
}