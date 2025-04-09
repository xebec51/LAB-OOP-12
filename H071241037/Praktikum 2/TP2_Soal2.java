

public class TP2_Soal2 {
   
    public static void main(String[] args) {
        Barang p = new Barang();
        p.id = "001";
        p.nama = "KTM";
        p.stok = 1;
        p.harga = 2500;
        
        p.tampilData();

    }
}

class Barang{

    String id;
    String nama;
    int stok;
    double harga;
    
    public boolean isTersedia() {
        return stok > 0;
    }
    
    public void tampilData() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Tersedia: " + (isTersedia() ? "Ya" : "Tidak"));
    }

}