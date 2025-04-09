public class live {                                

    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";
        
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Fariid";
        mahasiswa.nim = "H071241037";

        System.out.println("Nama: " + mahasiswa.getName());
        System.out.println("Nim: " + mahasiswa.getNim());
        mahasiswa.getAlamat();
    }
}

class Alamat{
    public String jalan;
    public String kota;
    public String getAlamatLengkap(){
        return jalan + ", " + kota;
    }
}

class Mahasiswa{
    public String nama;
    public String nim;
    public Alamat alamat;
    public String getName(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    public void getAlamat(){
        System.out.println(alamat.getAlamatLengkap());
    }
}