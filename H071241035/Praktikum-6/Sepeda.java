import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    String jenisSepeda;
    int jumlahGear;
    int ukuranRoda;
    double kecepatan;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() { return jenisSepeda; }

    public void setJenisSepeda(String jenis) { this.jenisSepeda = jenis; }

    public int getJumlahGear() { return jumlahGear; }
    
    public void setJumlahGear(int jumlah) { this.jumlahGear = jumlah; }

    public int getUkuranRoda() { return ukuranRoda; }

    public void setUkuranRoda(int ukuran) { this.ukuranRoda = ukuran; }

    @Override
    public boolean mulai() {
        System.out.println("Sepeda mulai dikayuh.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Sepeda berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }
    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }

    @Override
    public boolean periksaKondisi() { return true; }
    @Override
    public void lakukanServis() { System.out.println("Sepeda diservis."); }

    public Date getWaktuServisBerikutnya() { return new Date(); }
    @Override
    public double hitungBiayaServis() { return 100000; }

    @Override
    public double hitungPajak() { return 0; }
    @Override
    public String getTipeKendaraan() { return "Sepeda"; }
}