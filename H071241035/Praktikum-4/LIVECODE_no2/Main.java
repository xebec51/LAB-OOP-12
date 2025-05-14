package LIVECODE_no2;

public class Main {
    public static void main(String[] args) {
        KartuIdentitas kartu1 = new KartuIdentitas("Yayat Barren", 69692005);
        System.out.println(kartu1.getNamaLengkap());
        System.out.println(kartu1.getNik());
        System.out.println("--------------------------------------------");
        KartuIdentitas kartu2 = new KartuIdentitas("Dalvyn Suhada", 69692006);
        System.out.println(kartu2.getNamaLengkap());
        System.out.println(kartu2.getNik());
        System.out.println("--------------------------------------------");
        System.out.println(KartuIdentitas.getJumlahKartu());
    }
}
