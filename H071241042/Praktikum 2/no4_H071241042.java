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
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getNama() {
		return nama;
	}
	
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNim() {
		return nim;
	}
	
	public void setAlamat(Alamat alamat) {
		this.alamat = alamat;
	}
	public String getAlamat() {
		return alamat.toString();
	}
}

public class no4_H071241042 {
    public static void main(String[] args) {
		Alamat alamat       = new Alamat();
		alamat.jalan		= "Tamalanrea Indah";
		alamat.kota			= "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat	= alamat;
		mahasiswa.nama		= "Kime";
		mahasiswa.nim		= "H071241042";

		System.out.println("Nama   : " + mahasiswa.getNama());
		System.out.println("NIM    : " + mahasiswa.getNim());
		System.out.println("Alamat : " + mahasiswa.getAlamat());
	}

}