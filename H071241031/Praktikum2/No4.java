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
        return alamat.jalan + ", " + alamat.kota;
    }

}

public class No4 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Pampang";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Jonas";
        mahasiswa.nim = "H071241031";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Nim: " + mahasiswa.getAlamat());
    }
}
