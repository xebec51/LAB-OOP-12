public class Pembeli {
    String namaPembeli;
    int uang;
    String jusdibeli;
    
    public Pembeli() {
        this.namaPembeli = "null";
        this.uang = 0;
        this.jusdibeli = "null";
    }

    public Pembeli(String namaPembeli, int uang) {
        this.namaPembeli = namaPembeli;
        this.uang = uang;
        this.jusdibeli = "";
    }


    public void tampilkanInfo() {
        System.out.println("Nama: " + namaPembeli);
        System.out.println("Uang: Rp " + uang);
        System.out.println("Jus yang dibeli: " + (jusdibeli.isEmpty() ? "Belum membeli" : jusdibeli));
    }
}
