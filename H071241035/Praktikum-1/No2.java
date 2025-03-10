import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka yang dicari: ");
            int target = input.nextInt();

            boolean ditemukan = false;

            for (int baris = 0; baris < nums.length; baris++) {
                for (int kolom = 0; kolom < nums[baris].length; kolom++) {
                    if (nums[baris][kolom] == target) {
                        System.out.println("Found " + target + " at [" + baris + "][" + kolom + "]");
                        ditemukan = true;
                        break; 
                    }
                }
                if (ditemukan) break;
            }

            if (!ditemukan) {
                System.out.println(target + "tidak ditemukan dalam array.");
            }

        } catch (Exception e) {
            System.out.println("Input harus berupa bilangan bulat!");
        } finally {
            input.close();
        }
    }
}