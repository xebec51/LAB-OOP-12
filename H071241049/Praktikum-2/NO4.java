class Alamat {
    String jalan;
    String kota;

    public String getAlamat() {
        return jalan + ", " + kota;
    }
}
class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;

    public String getNama() {
        return nama;
    }
    public String getNim() {
        return nim;
    }
    public String getAlamat() {
        return alamat.getAlamat();
    }
}

public class NO4 {
    public static void main(String[] args) {
        //objek alamat
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalarea Indah";
        alamat.kota = "Makassar";

        //objek mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Tika";
        mahasiswa.nim = "H071241049";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}