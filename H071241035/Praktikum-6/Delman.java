public class Delman extends Kendaraan implements IBergerak {
    double kecepatan;
    String jenisKuda;

    public Delman(String merek, String model) {
        super(merek, model);
    }

    public Delman(String merek, String model, String jenisKuda) {
        super(merek, model);
       this.jenisKuda = jenisKuda;
    }

    @Override
    public boolean mulai() {
        if(jenisKuda == null) {
            System.out.println("Delman mulai berjalan, YEEEHAAWWW.");
        } else {
            System.out.println("Delman mulai berjalan, YEEEHAAWWW. " + jenisKuda + " Berlari Dengan Kencang.");
        }
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Kuda Ditarik EAA, Delman berhenti.");
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }
    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }

    public String getJenisKuda() { return jenisKuda; }
    public void setJenisKuda(String jenisKuda) { this.jenisKuda = jenisKuda; }

    @Override
    public double hitungPajak() { return 0; }
    @Override
    public String getTipeKendaraan() { return "Delman"; }

}

