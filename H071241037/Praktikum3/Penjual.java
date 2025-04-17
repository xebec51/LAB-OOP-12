
public class Penjual {
    String namaPenjual;
    Pembeli pembeli1;
    String jus;
    int harga;
    int total;

    public Penjual() {
        this.namaPenjual = "null";
        this.jus = "null";
        this.harga = 0;
        this.total = 0;
        this.pembeli1 = null;
    }

    public Penjual(String namaPenjual, String jus, int harga, Pembeli pembeli1) {
        this.namaPenjual = namaPenjual;
        this.jus = jus;
        this.harga = harga;
        this.total = 0;
        this.pembeli1 = pembeli1;
    }

    public void layaniPembeli() {
        if (pembeli1.uang >= harga) {
            pembeli1.uang -= harga;
            pembeli1.jusdibeli = jus;
            total += harga;
            System.out.println(namaPenjual + " menjual jus " + jus + " ke " + pembeli1.namaPembeli);
        } else {
            System.out.println(pembeli1.namaPembeli + " tidak cukup uang untuk membeli jus.");
        }
    }

    public void tampilkanTotalPenjualan() {
        System.out.println("Total penjualan " + namaPenjual + ": Rp " + total);
    }
}
