package LIVECODE_no2;

public class KartuIdentitas {
    private String namaLengkap;
    private final int nik;
    private static int jumlahKartu;

    public KartuIdentitas(String namaLengkap, int nik) {
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

    public int getNik() {
        return nik;
    }

    public static int getJumlahKartu() {
        return jumlahKartu;
    }
}



