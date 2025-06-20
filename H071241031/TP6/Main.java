package TP6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // ==== MOBIL ====
        System.out.println("==== MOBIL ====");
        Mobil mobil = new Mobil("Toyota", "Sport", 0, "Modern");
        mobil.setJumlahKursi(7);
        mobil.setBahanBakar("Bensin");
        System.out.println("Merk Mobil: " + mobil.getMerek());
        mobil.mulai();
        mobil.setKecepatan(60);
        System.out.println("Pajak: Rp" + mobil.hitungPajak());
        mobil.periksaKondisi();
        mobil.lakukanServis();
        Date servisMobil = mobil.getWaktuServisBerikutnya();
        if (servisMobil != null) {
            System.out.println("Servis berikutnya: " + sdf.format(servisMobil));
        }
        System.out.println("Biaya servis: Rp" + mobil.hitungBiayaServis());
        System.out.println();

        // ==== MOTOR ====
        System.out.println("==== MOTOR ====");
        Motor motor = new Motor("Yamaha", "Aerox", "Modern");
        motor.setKapasitasTangki(12);
        motor.setTipeSuspensi("Upside-down");
        System.out.println("Merk Motor: " + motor.getMerek());
        motor.mulai();
        motor.setKecepatan(80);
        System.out.println("Pajak: Rp" + motor.hitungPajak());
        motor.periksaKondisi();
        motor.lakukanServis();
        Date servisMotor = motor.getWaktuServisBerikutnya();
        if (servisMotor != null) {
            System.out.println("Servis berikutnya: " + sdf.format(servisMotor));
        }
        System.out.println("Biaya servis: Rp" + motor.hitungBiayaServis());
        System.out.println();

        // ==== SEPEDA ====
        System.out.println("==== SEPEDA ====");
        Sepeda sepeda = new Sepeda("Polygon", "MTB", "Konvensional");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);
        System.out.println("Merk Sepeda: " + sepeda.getMerek());
        sepeda.mulai();
        sepeda.setKecepatan(25);
        System.out.println("Pajak: Rp" + sepeda.hitungPajak());
        sepeda.periksaKondisi();
        sepeda.lakukanServis();
        Date servisSepeda = sepeda.getWaktuServisBerikutnya();
        if (servisSepeda != null) {
            System.out.println("Servis berikutnya: " + sdf.format(servisSepeda));
        }
        System.out.println("Biaya servis: Rp" + sepeda.hitungBiayaServis());
        System.out.println();
    }
}
