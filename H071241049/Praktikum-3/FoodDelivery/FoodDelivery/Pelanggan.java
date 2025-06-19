package FoodDelivery;

public class Pelanggan {
    String nama;
    Makanan pesanan;

    // Constructor default
    public Pelanggan() {
        this.nama = "Pelanggan Umum";
        this.pesanan = new Makanan();
    }

    // Constructor parameter
    public Pelanggan(String nama, Makanan pesanan) {
        this.nama = nama;
        this.pesanan = pesanan;
    }

    public void tampilkanPesanan() {
        System.out.println(nama + " memesan:");
        pesanan.tampilkanInfo();
    }
}

