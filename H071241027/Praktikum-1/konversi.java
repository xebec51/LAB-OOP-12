import java.util.Scanner;

public class konversi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bulan = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        String tanggal = scanner.nextLine();

        String[] splitTanggal = tanggal.split("-");

        int nomorTanggal = Integer.parseInt(splitTanggal[0]);
        int nomorBulan = Integer.parseInt(splitTanggal[1]);
        int nomorTahun = Integer.parseInt(splitTanggal[2]);

        try {

            if (nomorTahun < 0 || nomorTahun > 99) {
                throw new IllegalArgumentException("Tahun tidak valid! Tahun harus antara 00 dan 99.");
            }

            int tahunLengkap = (nomorTahun < 50) ? 2000 + nomorTahun : 1900 + nomorTahun;

            if (nomorBulan < 1 || nomorBulan > 12) {
                throw new IllegalArgumentException("Nomor bulan tidak valid!");
            }

            if (nomorTahun % 2 == 0) {
                if (nomorTanggal < 1 || nomorTanggal > 29) {
                    throw new IllegalArgumentException("Tanggal tidak valid!");
                }
            } else {
                if (nomorTanggal < 1 || nomorTanggal > 28) {
                    throw new IllegalArgumentException("Tanggal tidak valid!");
                }
            }

            System.out.println(nomorTanggal + " " + bulan[nomorBulan - 1] + " " + tahunLengkap);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
