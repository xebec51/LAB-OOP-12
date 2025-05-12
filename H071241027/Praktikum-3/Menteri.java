import java.util.ArrayList;
import java.util.List;

public class Menteri {
    String namaLengkap;
    String bidang;
    double kepercayaanPublik;
    List<String> staffKhusus;
    Kementerian kementerian;

    public Menteri() {
        this.namaLengkap = "";
        this.bidang = "";
        this.kepercayaanPublik = 0.0;
        this.staffKhusus = new ArrayList<>();
        this.kementerian = null;
    }

    public Menteri(String namaLengkap, String bidang, double kepercayaanPublik) {
        this.namaLengkap = namaLengkap;
        this.bidang = bidang;
        this.kepercayaanPublik = kepercayaanPublik;
        this.staffKhusus = new ArrayList<>();
        this.kementerian = null;
    }

    public void tambahStaff(String namaStaff) {
        staffKhusus.add(namaStaff);
        System.out.println(namaStaff + " ditambahkan sebagai staf khusus Menteri " + namaLengkap);
    }

    public void displayInfo() {
        System.out.println("\n Data Menteri ");
        System.out.println("Nama     : " + namaLengkap);
        System.out.println("Bidang   : " + bidang);
        System.out.println("Trust    : " + kepercayaanPublik);
        System.out.println("Staf Khusus : " + String.join(", ", staffKhusus));

        if (kementerian != null) {
            System.out.println("\n Kementerian yang Dipimpin ");
            kementerian.displayInfo();
        } else {
            System.out.println("Belum memimpin kementerian.");
        }
    }

    public String getNama() {
        return namaLengkap;
    }
}
