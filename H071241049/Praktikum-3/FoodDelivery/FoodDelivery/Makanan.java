package FoodDelivery;

public class Makanan {
    String nama;
    double harga;

    // Constructor default
    public Makanan() {
        this.nama = "Kwetiau";
        this.harga = 15000;
    }

    // Constructor parameter
    public Makanan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println(nama + " | Harga: Rp" + harga);
    }
}
