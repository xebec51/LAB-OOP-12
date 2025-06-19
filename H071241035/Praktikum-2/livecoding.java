package TUGAS_PRAKTIKUM_LAB_2;

public class livecoding {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.kota = "Makassar";
        alamat.jalan = "Kalampeto";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Dalvyn";
        mahasiswa.nim = "H071241035";

        System.out.println("Nama   : " + mahasiswa.getNama());
        System.out.println("Nim    : " + mahasiswa.getNim());
        System.out.println("Alamat : " + mahasiswa.getAlamat());
    }
}

class Alamat {
    String jalan;
    String kota;

    public String getAlamat() {
        return kota + "," + jalan;
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



