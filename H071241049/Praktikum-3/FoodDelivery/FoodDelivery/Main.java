package FoodDelivery;

public class Main {
    public static void main(String[] args) {
        Makanan m1 = new Makanan();
        Makanan m2 = new Makanan();

        Pelanggan p1 = new Pelanggan("Daffa", m1);
        Pelanggan p2 = new Pelanggan("Zalfa", m2);

        Delivery kurir1 = new Delivery("Kurir Iyad", p1);
        Delivery kurir2 = new Delivery("Kurir Yayat", p2);

        kurir1.antarPesanan();
        kurir2.antarPesanan();

        System.out.println("\n--- Tukar Tugas ---");
        kurir1.tukarTugas(kurir2);

        kurir1.antarPesanan();
        kurir2.antarPesanan();
    }
}
