public class no2_H071241042 {
    String id;
	String nama;
	int stok;
	double harga;

	public void setId(String newId) { 
		this.id = newId;}

	public void setNama(String newNama) { 
		this.nama = newNama;}

	public void setStok(int newStok) { 
		this.stok = newStok;}

	public void setHarga(double newHarga) { 
		this.harga = newHarga;}

	public int getstok() { 
		return this.stok;}

	public String getid() { 
		return this.id;}

	public String getnama() { 
		return this.nama;}

	public double getharga() { 
		return this.harga;}

	public void tampilkanInfoProduk() {
		System.out.println("ID Produk   : " + id);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Stok        : " + stok);
        System.out.println("Harga       : Rp " + harga);
	}

	public boolean tersediaDiStok() {
        return stok > 0;
    }

	public static void main(String[] args) {
		no2_H071241042 barang = new no2_H071241042();
		barang.setNama("Hoka");
		barang.setId("011");
		barang.setStok(10);
		barang.setHarga(3000000);
		barang.tampilkanInfoProduk();
		if (barang.tersediaDiStok()) {
			System.out.println("Status Produk: tersedia");
		} else {
			System.out.println("Status Produk: habis");
		}
	}

}