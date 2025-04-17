public class Pembeli {
    String nama;
    Kue kue; // objek dari class Kue

    public Pembeli() {
        this.nama = "Anonim";
        this.kue = new Kue();
    }

    public Pembeli(String nama, Kue kue) {
        this.nama = nama;
        this.kue = kue;
    }

    public int totalBayar() {
        return kue.hitungHarga();
    }

    public void bandingkanPembayaran(Pembeli pembeliLain) {
        if (this.totalBayar() > pembeliLain.totalBayar()) {
            System.out.println(this.nama + " membayar lebih banyak dari " + pembeliLain.nama);
        } else if (this.totalBayar() < pembeliLain.totalBayar()) {
            System.out.println(pembeliLain.nama + " membayar lebih sedikit dari " + this.nama);
        } else {
            System.out.println(this.nama + " dan " + pembeliLain.nama + " membayar dengan jumlah yang sama.");
        }
    }
}
