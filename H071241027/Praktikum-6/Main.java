package tp6;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- 1. Membuat Objek Kendaraan ---");

        Mobil mobil = new Mobil("Toyota", "Avanza", 5000, "MPV");
        Motor motor = new Motor("Honda", "Vario 160", "Skuter Matik");
        Sepeda sepeda = new Sepeda("Polygon", "Strattos S5", "Road Bike");
        Kuda kuda = new Kuda("K01", "Lokal", "Pacu", "Coklat", 2020, "Kuda Pacu");

        System.out.println("Objek Mobil, Motor, Sepeda, dan Kuda (tugas no. 2) berhasil dibuat.\n");

        System.out.println("--- 2. Demo Method Individual ---");

        System.out.println("-> Info Mobil:");
        mobil.mulai();
        mobil.setKecepatan(80.5);
        System.out.println("Tipe Kendaraan: " + mobil.getTipeKendaraan());
        System.out.println("Kecepatan saat ini: " + mobil.getKecepatan() + " km/jam");
        mobil.berhenti();
        System.out.println("Pajak Mobil (estimasi): Rp" + mobil.hitungPajak());

        mobil.updateKilometer(15000);
        System.out.println("Apakah mobil perlu diservis? " + !mobil.periksaKondisi());
        System.out.println("Biaya servis yang dibutuhkan: Rp" + mobil.hitungBiayaServis());
        mobil.lakukanServis();
        System.out.println();

        System.out.println("-> Info Kuda (Kelas Tambahan dari Tugas 2):");
        kuda.mulai();
        kuda.setKecepatan(40.0);
        System.out.println("Tipe Kendaraan: " + kuda.getTipeKendaraan());
        System.out.println("Kecepatan Kuda: " + kuda.getKecepatan());
        System.out.println("Pajak Kuda: Rp" + kuda.hitungPajak());

        System.out.println("Kuda tidak memiliki method lakukanServis().\n");

        System.out.println("--- 3. Demo Polimorfisme via Interface IBergerak ---");

        List<IBergerak> bisaBergerak = new ArrayList<>();
        bisaBergerak.add(mobil);
        bisaBergerak.add(motor);
        bisaBergerak.add(sepeda);
        bisaBergerak.add(kuda);

        // Looping melalui list dan memanggil method dari interface IBergerak
        for (IBergerak item : bisaBergerak) {
            System.out.println("Memproses objek: " + item.getClass().getSimpleName());
            item.mulai();
            item.berhenti();
            System.out.println("-----");
        }
        System.out.println();

        System.out.println("--- 4. Demo Polimorfisme via Interface IServiceable ---");

        List<IServiceable> bisaDiservis = new ArrayList<>();
        bisaDiservis.add(mobil);
        bisaDiservis.add(motor);
        bisaDiservis.add(sepeda);

        for (IServiceable item : bisaDiservis) {
            System.out.println("Memeriksa servis untuk: " + item.getClass().getSimpleName());
            if (!item.periksaKondisi()) {
                System.out.println("Kendaraan perlu diservis. Biaya: Rp" + item.hitungBiayaServis());
                item.lakukanServis();
            } else {
                System.out.println("Kondisi masih baik. Servis berikutnya sekitar: " + item.getWaktuServisBerikutnya());
            }
            System.out.println("-----");
        }
    }
}