

class TP2_Soal4 {

    static class Alamat {
        public String jalan;
        public String kota;
        public String getAlamatLengkap() {
            return jalan + ", " + kota;
        }
    }
    
    static class Mahasiswa {
        public Alamat alamat;
        public String nama;
        public String nim;
    
        public String getNama() {
            return nama;
        }
        public String getNim() {
            return nim;
        }
        public String getAlamat() {
            return alamat.getAlamatLengkap();
        }
    }
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Poros Malino";
        alamat.kota = "Makassar";
    
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Pareddd";
        mahasiswa.nim = "H071241037";
    
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}
