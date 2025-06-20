
class Alamat {
    String jalan, kota;
}

class Mahasiswa {
    Alamat alamat;
    String nama, nim;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getAlamat() {
        return alamat.jalan + "," + alamat.kota;
    }
}

public class livecoding {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "pettarani";
        alamat.kota = "makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.nama = "wanul";
        mahasiswa.nim = "027";
        mahasiswa.alamat = alamat;

        System.out.println("Nama : " + mahasiswa.getNama());
        System.out.println("Nim : " + mahasiswa.getNim());
        System.out.println("Alamat " + mahasiswa.getAlamat());
    }
}
