package tp6;

import java.util.Calendar;
import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    protected String jenisSepeda;
    protected int jumlahGear, ukuranRoda;
    protected double kecepatan;
    private boolean sedangBerjalan = false;

    private int jarakTempuh = 0;
    private int batasServis = 1000;
    private boolean kondisiBaik = true;
    private Date waktuServisTerakhir;

    public Sepeda(String merek, String model, String tipeKendaraan) {
        this.merek = merek;
        this.model = model;
        this.tipeKendaraan = tipeKendaraan;
        this.waktuServisTerakhir = new Date();
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }

    @Override
    public double hitungPajak() {
        return 0.0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

    @Override
    public boolean mulai() {
        if (!sedangBerjalan) {
            sedangBerjalan = true;
            kecepatan = 5.0;
            System.out.println("Sepeda mulai bergerak.");
            return true;
        }
        System.out.println("Sepeda sudah berjalan.");
        return false;
    }

    @Override
    public boolean berhenti() {
        if (sedangBerjalan) {
            sedangBerjalan = false;
            kecepatan = 0.0;
            // Tambah jarak tempuh simulasi setiap kali berhenti
            jarakTempuh += 100; // misalnya tambah 100km untuk contoh
            System.out.println("Sepeda berhenti.");
            return true;
        }
        System.out.println("Sepeda sudah berhenti.");
        return false;
    }

    @Override
    public double getKecepatan() {
        return this.kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (sedangBerjalan) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan diubah menjadi " + kecepatan + " km/jam");
        } else {
            System.out.println("Sepeda belum mulai, tidak bisa ubah kecepatan.");
        }
    }

    @Override
    public boolean periksaKondisi() {
        if (jarakTempuh >= batasServis) {
            kondisiBaik = false;
        } else {
            kondisiBaik = true;
        }
        return kondisiBaik;
    }

    @Override
    public void lakukanServis() {
        if (!periksaKondisi()) {
            System.out.println("Melakukan servis sepeda...");
            jarakTempuh = 0;
            waktuServisTerakhir = new Date();
            kondisiBaik = true;
        } else {
            System.out.println("Sepeda masih dalam kondisi baik. Tidak perlu servis.");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(waktuServisTerakhir);
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        if (!kondisiBaik) {
            return 150_000.0;
        }
        return 0.0;
    }
}
