public class Main {
    public static void main(String[] args) {
        Delman delman1 = new Delman("FERRARI", "TDR3000", "Pinky Pie");
        delman1.setTahunProduksi(2020);
        delman1.setWarna("BLACK");
        delman1.setKecepatan(15.0);

        System.out.println("Delman ID: " + delman1.getId());
        System.out.println("Merek: " + delman1.getMerek());
        System.out.println("Model: " + delman1.getModel());
        System.out.println("Tahun Produksi: " + delman1.getTahunProduksi());
        System.out.println("Warna: " + delman1.getWarna());
        System.out.println("Jenis Kuda: " + delman1.getJenisKuda());
        System.out.println("----------------------------------------------------------");
        delman1.mulai();
        System.out.println("Kecepatan: " + delman1.getKecepatan() + " km/h");
        System.out.println("----------------------------------------------------------");       
        delman1.berhenti();

        System.out.println("----------------------------------------------------------");  
        Mobil mobil1 = new Mobil("Lamborghini", "Aventador");
        mobil1.setWarna("Hitam");
        mobil1.setTahunProduksi(2022);
        mobil1.setBahanBakar("Vpower");
        mobil1.setKapasitasMesin(2200);
        mobil1.setJumlahKursi(2);
        mobil1.setJumlahPintu(2);
        mobil1.setKecepatan(122);

        System.out.println("ID MOBIL: " + mobil1.getId());
        System.out.println("Merek: " + mobil1.getMerek());
        System.out.println("Model: " + delman1.getModel());
        System.out.println("Tahun Produksi: " + mobil1.getTahunProduksi());
        System.out.println("Warna: " + mobil1.getWarna());
        System.out.println("Jumlah Pintu: " + mobil1.getJumlahPintu());
        System.out.println("Jumlah Kursi: " + mobil1.getJumlahKursi());
        System.out.println("----------------------------------------------------------");
        mobil1.mulai();
        System.out.println("Kecepatan: " + mobil1.getKecepatan() + " km/h");
        System.out.println("----------------------------------------------------------");       
        mobil1.berhenti();


    }
}


