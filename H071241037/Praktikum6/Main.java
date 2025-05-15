package Praktikum6;

public class Main {
    public static void main(String[] args) {

        Mobil mobil =new Mobil("Toyota", "Avanza");
        mobil.setTahunProduksi(2020);
        mobil.setWarna("merah");
        mobil.setJumlahKursi(4);
        mobil.setJumlahPintu(4);
        mobil.setKecepatan(100);
        mobil.setBahanBakar("Bensin");

        Motor motor = new Motor("Yamaha", "Aerox");
        motor.setTahunProduksi(2024);
        motor.setWarna("Hitam");
        motor.setJenisMotor("Skuter");
        motor.setTipeSuspensi("Telescopic");
        motor.setKecepatan(80);

        Sepeda sepeda = new Sepeda("Polygon", "Bike");
        sepeda.setTahunProduksi(2025);
        sepeda.setWarna("Ungu");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setUkuranRoda(26);
        sepeda.setJumlahGear(21);
        sepeda.setKecepatan(15);

        Skateboard skateboard = new Skateboard("Element", "Skate");
        skateboard.setTahunProduksi(2025);
        skateboard.setWarna("Hitam");
        skateboard.setJenisDeck("Popsicle");
        skateboard.setAdaGripTape(true);
        skateboard.setKecepatan(15);

        tampilkanInfoKendaraan(mobil);
        tampilkanInfoKendaraan(motor);
        tampilkanInfoKendaraan(sepeda);
        tampilkanInfoKendaraan(skateboard);

    }

    public static void tampilkanInfoKendaraan(Kendaraan k){
        System.out.println("====" + k.getTipeKendaraan() + "====");
        System.out.println("Merek: " + k.getMerek());
        System.out.println("Warna: " + k.getWarna());
        System.out.println("Tahun Produksi: " + k.getTahunProduksi());
        System.out.println("Pajak: Rp" + k.hitungPajak());

        if (k instanceof Mobil ){
            Mobil m = (Mobil) k;
            System.out.println("Jumlah Pintu: " + m.getJumlahPintu());
            System.out.println("Kapasitas Mesin: " +  m.getKapasitasMesin());
            System.out.println("Jumlah Kursi: " + m.getJumlahKursi());
            System.out.println("Bahan Bakar: " + m.getBahanBakar() + "L");

        
        } else if (k instanceof Motor){
            Motor m = (Motor) k;
            System.out.println("Jenis Motor: " +  m.getJenisMotor());
            System.out.println("Tipe Suspensi: " + m.getTipeSuspensi());
            System.out.println("Kapasitas Tangki: " + m.getKapasitasTangki() + "L");
        }
        else if (k instanceof Sepeda){
            Sepeda s = (Sepeda) k;
            System.out.println("Jumlah Gear: " + s.getJumlahGear());                     
            System.out.println("Ukuran Roda: " + s.getUkuranRoda() + "inci");
            
        }
        else if (k instanceof Skateboard){
            Skateboard sk = (Skateboard) k;
            System.out.println("Jenis Deck: " + sk.getJenisDeck());
            System.out.println("Grip: " + sk.getAdaGripTape());
        
    }
    if (k instanceof IBergerak){
        IBergerak b = (IBergerak) k;
        System.out.println("Kecepatan: " + b.getKecepatan() + "Km/Jam");
    }
    if (k instanceof IServiceable){
        IServiceable s = (IServiceable) k;
        s.lakukanServis();
        System.out.println("Servis Berikutnya: " + s.getWaktuServisBerikutnya());
    }
    System.out.println();
    }
}