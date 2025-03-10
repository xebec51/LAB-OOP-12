package TUPRAK1; 
import java.util.Scanner;

public class NO3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String tanggal = input.nextLine();

        try {
            String[] bagian = tanggal.split("-");

            if (bagian.length != 3) {
                throw new Exception();
            }

            int hari = Integer.parseInt(bagian[0]);
            int bulan = Integer.parseInt(bagian[1]);
            String tahunStr = bagian[2];

            if (tahunStr.length() != 2) {
                System.out.println("Input tahun tidak valid. Harus dua digit.");
            } else {
                int tahun = Integer.parseInt(tahunStr);

                if (tahun <= 25) {
                    tahun += 2000;
                } else {
                    tahun += 1900;
                }

                //array nama-nama bulan
                String[] namaBulan = {
                    "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                    "Juli", "Agustus", "September", "Oktober", "November", "Desember"
                };

                //validasi tanggal dan bulan
                if (hari < 1 || hari > 30) {
                    System.out.println("Input tanggal tidak valid. Harus antara 1-30.");
                } else if (bulan < 1 || bulan > 12) {
                    System.out.println("Input bulan tidak valid. Harus antara 1-12.");
                } else {
                    System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahun);
                }
            }
        } catch (Exception e) {
            System.out.println("Format tanggal tidak valid. Harus dd-mm-yy.");
        }

        input.close();
    }
}
