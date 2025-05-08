package transportasi;

public class Main {
    public static void main(String[] args) {
        Mobil m1 = new Mobil("Avanza","Toyota");
        Motor mot1 = new Motor("Honda","Scoopy");
        Sepeda s1 = new Sepeda("Polygon", "TDR 3000");
        Bajaj b1 = new Bajaj("Dalvin", "Daffa");

        m1.setJumlahPintu(4);
        m1.setKapasitasMesin(1000);
        m1.setJumlahKursi(8);
        m1.setBahanBakar("Pertamax");
        System.out.println("Mobil ini sedang berjalan: " + m1.mulai());
        System.out.println("Kecepatan mobil ini: " + m1.getKecepatan());
        System.out.println("Mobil ini telah berhenti: " + m1.berhenti());
        System.out.println("========================================");

        mot1.setKecepatan(100);
        mot1.setKapasitasMesin(2000);
        mot1.setTahunProduksi(2007);
        mot1.setWarna("Maroon");
        mot1.setMemilikiBoxBelakang(false);
        System.out.println("Motor ini sedang berjalan: " + mot1.mulai());
        System.out.println("Motor ini memiliki kapasitas mesin: " + mot1.getKapasitasMesin());
        System.out.println("Motor ini diproduksi pada tahun: " + mot1.getTahunProduksi());
        System.out.println("Motor ini berwarna: " + mot1.getWarna());
        System.out.println("Motor ini memiliki box belakang: " + mot1.getTipeKendaraan());
        System.out.println("========================================");

        s1.setJenisSepeda("Gunung");
        s1.setJumlahGear(3);
        s1.setKecepatan(20);
        s1.setTahunProduksi(2000);
        s1.setUkuranRoda(14);
        s1.setWarna("Hitam");
        System.out.println("Jenis sepeda ini: " + s1.getJenisSepeda());
        System.out.println("Jumlah gear: " + s1.getJumlahGear());
        System.out.println("Kecepatan sepeda ini: " + s1.getKecepatan());
        System.out.println("Sepeda ini diproduksi pada tahun: " + s1.getTahunProduksi());
        System.out.println("Ukuran roda sepeda ini: " + s1.getUkuranRoda());
        System.out.println("Sepeda ini berwarna: " + s1.getWarna());
        System.out.println("========================================");

        b1.setJumlahPenumpang(8);
        b1.setKecepatan(100);
        b1.setTahunProduksi(2009);
        b1.setWarna("Biru");
        System.out.println("Jumlah penumpang bajaj ini: " + b1.getJumlahPenumpang());
        System.out.println("Kecepatan bajaj ini: " + b1.getKecepatan());
        System.out.println("Bajaj ini diproduksi pada tahun: " + b1.getTahunProduksi());
        System.out.println("Bajaj ini berwarna: " + b1.getWarna());
        System.out.println("========================================");
    }
}
