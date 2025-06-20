package TP6;

public class Perahu extends Kendaraan implements IBergerak {
    private String jenisPerahu;      // Contoh: "Perahu Layar", "Kano"
    private double kecepatan = 0.0;  // Kecepatan perahu (km/jam)
    private boolean sedangBerlayar = false;

    public Perahu(String id,
                  String merek,
                  String model,
                  String warna,
                  int tahunProduksi,
                  String jenisPerahu) {

        this.id             = id;
        this.merek          = merek;
        this.model          = model;
        this.warna          = warna;
        this.tahunProduksi  = tahunProduksi;
        this.jenisPerahu    = jenisPerahu;
        this.tipeKendaraan  = "Air";
    }

    /* ---------- Getter & Setter spesifik ---------- */
    public String getJenisPerahu() {
        return jenisPerahu;
    }

    public void setJenisPerahu(String jenisPerahu) {
        this.jenisPerahu = jenisPerahu;
    }

    /* ---------- Override metode dari Kendaraan / IBergerak ---------- */
    @Override
    public double hitungPajak() {
        // Misalnya perahu pribadi tidak dikenai pajak di konteks ini
        return 0.0;
    }

    @Override
    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    @Override
    public boolean mulai() {
        if (!sedangBerlayar) {
            sedangBerlayar = true;
            kecepatan = 8.0; // Kecepatan awal perahu (km/jam)
            System.out.println("Perahu mulai berlayar.");
            return true;
        }
        System.out.println("Perahu sudah berlayar.");
        return false;
    }

    @Override
    public boolean berhenti() {
        if (sedangBerlayar) {
            sedangBerlayar = false;
            kecepatan = 0.0;
            System.out.println("Perahu berhenti.");
            return true;
        }
        System.out.println("Perahu sudah berhenti.");
        return false;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (sedangBerlayar) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan perahu diubah menjadi " + kecepatan + " km/jam.");
        } else {
            System.out.println("Perahu belum mulai berlayar, tidak bisa ubah kecepatan.");
        }
    }
}

