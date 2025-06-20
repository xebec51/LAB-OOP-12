import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        int matriks[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan angka yang ingin dicari: ");
        int target = scanner.nextInt();
        scanner.close();
        
        boolean found = false;
        int foundRow = -1, foundCol = -1;
         
        for(int i = 0; i < matriks.length && !found; i++) {
            int col = cariAngka(matriks, i, target);
            if (col != -1) {
                found = true;
                foundRow = i;
                foundCol = col;
            }
        }
         
        if (found) {
            System.out.println("Found "+target+" at"+" ["+foundRow+"]["+foundCol+"]");
        } else {
            System.out.println("Angka tidak ditemukan.");
        }
    }
     
    public static int cariAngka(int array[][], int row, int target) {
        int awalMatriks = 0;
        int akhirMatriks = array[row].length - 1;
        
        while (awalMatriks <= akhirMatriks) {
            int middle = (awalMatriks + akhirMatriks) / 2;
            
            if (array[row][middle] == target) {
                return middle;
            } else if (array[row][middle] > target) {
                akhirMatriks = middle - 1;
            } else {
                awalMatriks = middle + 1;
            }
        }
        
        return -1;
    }
}
