public class KartuIdentitas { 
    private String namaLengkap;
    private final String nik;

    private static int jumlahKartu = 0;

    public KartuIdentitas(String namaLengkap, String nik) {
        this.namaLengkap = namaLengkap;
        this.nik = nik;
        jumlahKartu++; 
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        System.out.println("Error NIK tdk dapat diubah");
    }

    public static int getJumlahKartu() {
        return jumlahKartu;
    }
}
