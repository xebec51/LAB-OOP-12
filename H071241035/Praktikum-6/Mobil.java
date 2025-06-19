import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    int jumlahPintu;
    double kapasitasMesin;
    int jumlahKursi;
    String bahanBakar;
    double kecepatan;

    public Mobil(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() { return jumlahPintu; }

    public void setJumlahPintu(int jumlah) { this.jumlahPintu = jumlah; }

    public double getKapasitasMesin() { return kapasitasMesin; }

    public void setKapasitasMesin(double kapasitas) { this.kapasitasMesin = kapasitas; }

    public int getJumlahKursi() { return jumlahKursi; }

    public void setJumlahKursi(int jumlah) { this.jumlahKursi = jumlah; }

    public String getBahanBakar() { return bahanBakar; }
    
    public void setBahanBakar(String bb) { this.bahanBakar = bb; }

    @Override
    public boolean mulai() {
        System.out.println("Mobil dinyalakan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }
    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }

    @Override
    public boolean periksaKondisi() { return true; }
    @Override
    public void lakukanServis() { System.out.println("Mobil diservis."); }
    
    public Date getWaktuServisBerikutnya() { return new Date(); }
    @Override
    public double hitungBiayaServis() { return 500000; }

    @Override
    public double hitungPajak() { return 1000000; }
    @Override
    public String getTipeKendaraan() { return "Mobil"; }
}
