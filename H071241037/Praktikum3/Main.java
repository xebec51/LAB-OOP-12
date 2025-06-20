public class Main {
    public static void main(String[] args) {
        Pembeli pembeli1 = new Pembeli("Budi", 15000);
        Pembeli pembeli2 = new Pembeli("Tina", 10000);
        Penjual penjual = new Penjual("Siti", "Jus Alpukat", 12000, pembeli1);
        Penjual penjual1 = new Penjual("fariid","Jus Apel", 11000, pembeli2);
       
        
        penjual.layaniPembeli();
        penjual1.layaniPembeli();

        pembeli1.tampilkanInfo();
        pembeli2.tampilkanInfo();

        penjual.tampilkanTotalPenjualan();
        penjual1.tampilkanTotalPenjualan();
    }
}
