package Praktikum6;

public class Skateboard extends Kendaraan implements IBergerak {
    private String jenisDeck;
    private boolean adaGripTape;
    private double kecepatan;

    public Skateboard(String merek, String model) {
        super(merek, model);
        setTipeKendaraan("Skateboard");
    }

    public String getJenisDeck() {
        return jenisDeck;
    }

    public void setJenisDeck(String jenisDeck) {
        this.jenisDeck = jenisDeck;
    }

    public boolean getAdaGripTape() {
        return adaGripTape;
    }

    public void setAdaGripTape(boolean adaGripTape) {
        this.adaGripTape = adaGripTape;
    }

    @Override
    public void mulai() {
        System.out.println("Skateboard mulai meluncur.");
    }

    @Override
    public void berhenti() {
        System.out.println("Skateboard berhenti.");
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public double hitungPajak() {
        return 0;
    }
}
