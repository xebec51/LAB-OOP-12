class Alamat {
    String jalan;
    String kota;

    public String toString() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;
}

public class tes {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Maros";
        alamat.kota = "Maros";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Kime";
        mahasiswa.nim = "H071241042";

        System.out.println("Nama   : " + mahasiswa.nama);
        System.out.println("NIM   : " + mahasiswa.nim);
        System.out.println("Alamat   : " + mahasiswa.alamat);
    }
}