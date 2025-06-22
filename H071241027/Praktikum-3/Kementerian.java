public class Kementerian {
    public enum StatusKementerian {
        AKTIF, TIDAK_AKTIF
    }

    String kode;
    String nama;
    String bidang;
    double anggaran;
    StatusKementerian status;

    public Kementerian(String kode, String nama, String bidang, double anggaran, StatusKementerian status) {
        this.kode = kode;
        this.nama = nama;
        this.bidang = bidang;
        this.anggaran = anggaran;
        this.status = status;
    }

    public void setStatus(StatusKementerian status) {
        this.status = status;
    }

    public void displayInfo() {
        System.out.println("Kode Kementerian : " + kode);
        System.out.println("Nama             : " + nama);
        System.out.println("Bidang           : " + bidang);
        System.out.println("Anggaran         : Rp" + anggaran);
        System.out.println("Status           : " + status);
    }
}
