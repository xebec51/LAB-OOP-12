public class Kue {
    String ukuran; // kecil, sedang, besar
    int hargaDasar;
    Topping topping; // objek dari class Topping

    public Kue() {
        this.ukuran = "sedang";
        this.hargaDasar = 20000;
        this.topping = new Topping();
    }

    public Kue(String ukuran, int hargaDasar, Topping topping) {
        this.ukuran = ukuran;
        this.hargaDasar = hargaDasar;
        this.topping = topping;
    }

    public int hitungHarga() {
        int total = hargaDasar + topping.harga;
        if (ukuran.equals("kecil")) {
            total -= 5000;
        } else if (ukuran.equals("besar")) {
            total += 10000;
        }
        return total;
    }

    public void tampilkanInfo() {
        System.out.println("Ukuran          : " + ukuran);
        System.out.println("Topping         : " + topping.nama);
        System.out.println("Total Harga     : Rp" + hitungHarga());
    }
}
