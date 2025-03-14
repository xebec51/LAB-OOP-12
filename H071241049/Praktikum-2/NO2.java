public class NO2 {
    int id;
    String nama;
    int stok;
    double harga;

    public NO2 (int id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }
    public void infoStock() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp " + harga);
    }
    //method cek produk dalam stok
    public boolean statusStok() {
        return stok > 0;
    }
    public static void main(String[] args) {
        NO2 produk1 = new NO2 (1, "Laptop", 0, 7500000);
        produk1.infoStock();

        //cek ketersediaan stok
        if (produk1.statusStok()) {
            System.out.println("Produk ini tersedia");
        } else {
            System.out.println("Produk ini tidak tersedia");
        }
    }
}