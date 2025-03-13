import java.util.Scanner;

public class no_3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            // Minta pengguna input tanggal
            System.out.print("Masukkan tanggal (dd-mm-yy): ");
            String tanggal = input.nextLine();
            
            // Pisah tanggal jadi hari, bulan, dan tahun
            String[] bagian = tanggal.split("-");
            
            int hari = Integer.parseInt(bagian[0]);
            int bulan = Integer.parseInt(bagian[1]);
            int tahun = Integer.parseInt(bagian[2]);

            if (tahun >= 25 && tahun <= 99) {
                tahun += 1900;
            } else {
                tahun += 2000;
            }
            
            // Konversi tahun ke format 4 digit
            // tahun = (tahun > 26) ? (2000 + tahun) : (1900 + tahun);
            
            // Cek validitas tanggal
            if (isTanggalValid(hari, bulan, tahun)) {
                // Array nama bulan
                String[] namaBulan = {
                    "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                    "Juli", "Agustus", "September", "Oktober", "November", "Desember"
                };
                
                // Tampilkan hasil konversi
                System.out.println("Output : " + hari + " " + namaBulan[bulan - 1] + " " + tahun);
            } else {
                System.out.println("Input tidak valid!");
            }
        } catch (Exception e) {
            System.out.println("Format input salah! Gunakan format dd-mm-yy.");
        } finally {  
            input.close();
        }
    }
    
    public static boolean isTanggalValid(int hari, int bulan, int tahun) {
        // Cek apakah bulan valid
        if (bulan < 1 || bulan > 12) {
            return false;
        }
        
        // Cek jumlah hari dalam bulan
        int[] jumlahHariPerBulan = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Cek tahun kabisat untuk Februari
        if (bulan == 2 && isTahunKabisat(tahun)) {
            jumlahHariPerBulan[1] = 29; // Februari memiliki 29 hari pada tahun kabisat
        }
        
        // Cek apakah hari valid
        if (hari < 1 || hari > jumlahHariPerBulan[bulan - 1]) {
            return false;
        }
        
        return true;
    }
    
    // Method untuk mengecek tahun kabisat
    public static boolean isTahunKabisat(int tahun) {
        // Tahun kabisat adalah tahun yang habis dibagi 4,
        // kecuali tahun yang habis dibagi 100 tetapi tidak habis dibagi 400.
        return (tahun % 4 == 0 && (tahun % 100 != 0 || tahun % 400 == 0));
    }
}