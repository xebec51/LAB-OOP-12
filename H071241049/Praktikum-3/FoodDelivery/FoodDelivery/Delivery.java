package FoodDelivery;

public class Delivery {
    String namaKurir;
    Pelanggan pelanggan;
    Delivery partner; // self-referencing object

    public Delivery() {
        this.namaKurir = "Kurir Iyad";
        this.pelanggan = new Pelanggan();
    }

    // Constructor parameter
    public Delivery(String namaKurir, Pelanggan pelanggan) {
        this.namaKurir = namaKurir;
        this.pelanggan = pelanggan;
    }

    public void antarPesanan() {
        System.out.println("[" + namaKurir + "] mengantar pesanan untuk " + pelanggan.nama);
        pelanggan.tampilkanPesanan();
    }

    // Method: interaksi antar objek dari class yang sama (DeliveryService)
    public void tukarTugas(Delivery partner) {
        Pelanggan temp = this.pelanggan;
        this.pelanggan = partner.pelanggan;
        partner.pelanggan = temp;
        System.out.println("Tugas kurir ditukar antara " + this.namaKurir + " dan " + partner.namaKurir);
    }
}

