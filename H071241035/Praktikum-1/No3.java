import java.util.*;
public class No3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tanggal: ");
        String tanggal = input.next();

        String[] tanggalSplit = tanggal.split("-");

        String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        try {
            int tanggalInt = Integer.parseInt(tanggalSplit[0]);
            int bulanInt = Integer.parseInt(tanggalSplit[1]);
            int tahunInt = Integer.parseInt(tanggalSplit[2]);

            if (tanggalSplit[2].length() > 2) {
                throw new Exception("Tahun harus terdiri dari 2 karakter.");
            }

            if (bulanInt < 1 || bulanInt > 12) {
                throw new Exception("Bulan harus antara 1 dan 12.");
            }

            int tahunKonversi;
            if (tahunInt < 50) {
                tahunKonversi = 2000 + tahunInt;
            } else {
                tahunKonversi = 1900 + tahunInt;
            }

            String tanggalKonversi = tanggalInt + " " + namaBulan[bulanInt-1] + " " + tahunKonversi;

            System.out.println("Output: " + tanggalKonversi);
        } catch (NumberFormatException e) {
            System.out.println("Error: Input harus berupa angka.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}

