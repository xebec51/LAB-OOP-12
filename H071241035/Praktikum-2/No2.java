package TUGAS_PRAKTIKUM_LAB_2;

class Validasi {
    String id, nama;
    int stok, harga;

    String getStock(){
        return this.stok > 0 ? "Tersedia" : "Habis";
    }
    int getHarga(){
        return this.harga;
    }
    String getNama(){
        return this.nama;
    }
    String getId(){
        return this.id;
    }
    String getItem(){
        return "Barang : " + this.getNama() + "\nID : " + this.getId() 
                +  "\nHarga : " + this.getHarga() + "\nStok : " + this.getStock();
    }
}

public class No2 {
    public static void main(String[] args) {
        Validasi Validasi = new Validasi();
        Validasi.id = "ZX001";
        Validasi.nama = "RAM";
        Validasi.stok = 0;
        Validasi.harga = 5000;
        System.out.println(Validasi.getItem());
    }
}
