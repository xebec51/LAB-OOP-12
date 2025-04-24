public class Main {
    public static void main(String[] args) {
        KartuIdentitas kartu1 = new KartuIdentitas("Tika", "1234567890123456");
        KartuIdentitas kartu2 = new KartuIdentitas("L", "6543210987654321");

        System.out.println("Kartu 1:");
        System.out.println("Nama: " + kartu1.getNamaLengkap());
        System.out.println("NIK : " + kartu1.getNik());

        System.out.println("\nKartu 2:");
        System.out.println("Nama: " + kartu2.getNamaLengkap());
        System.out.println("NIK : " + kartu2.getNik());

        kartu1.setNamaLengkap("Tika");
        System.out.println("\nNama setelah diubah (kartu 1): " + kartu1.getNamaLengkap());

        kartu1.setNik("0000000000000000");

        System.out.println("\nJumlah kartu yang dibuat: " + KartuIdentitas.getJumlahKartu());
    }
}
