public class Bioskop {
    private String nama;
    private int kapasitas;
    private Film filmYangDiputar; 
    private int jumlahPenonton;

    public Bioskop() {
        this.nama = "Bioskop XYZ";
        this.kapasitas = 100;
        this.filmYangDiputar = new Film();
        this.jumlahPenonton = 0;
    }

    public Bioskop(String nama, int kapasitas, Film filmYangDiputar) {
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.filmYangDiputar = filmYangDiputar;
        this.jumlahPenonton = 0;
    }

    public void tambahPenonton(int jumlah) {
        if (jumlahPenonton + jumlah <= kapasitas) {
            jumlahPenonton += jumlah;
            System.out.println(jumlah + " penonton berhasil masuk. Total penonton: " + jumlahPenonton);
        } else {
            System.out.println("Kapasitas tidak mencukupi. Hanya bisa menambahkan " + (kapasitas - jumlahPenonton) + " penonton.");
        }
    }

    public void pindahkanPenontonKe(Bioskop bioskopLain, int jumlah) {
        if (this.jumlahPenonton >= jumlah) {
            if (bioskopLain.kapasitas - bioskopLain.jumlahPenonton >= jumlah) {
                this.jumlahPenonton -= jumlah;
                bioskopLain.tambahPenonton(jumlah);
                System.out.println(jumlah + " penonton dipindahkan dari " + this.nama + " ke " + bioskopLain.nama);
            } else {
                System.out.println("Bioskop tujuan tidak memiliki kapasitas cukup.");
            }
        } else {
            System.out.println("Tidak cukup penonton untuk dipindahkan.");
        }
    }

    public void displayInfo() {
        System.out.println("Nama Bioskop: " + nama);
        System.out.println("Kapasitas: " + kapasitas);
        System.out.println("Jumlah Penonton: " + jumlahPenonton);
        System.out.println("Film yang diputar: " + filmYangDiputar.getJudul());
        System.out.println("Sisa kursi: " + (kapasitas - jumlahPenonton));
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public Film getFilmYangDiputar() {
        return filmYangDiputar;
    }

    public void setFilmYangDiputar(Film filmYangDiputar) {
        this.filmYangDiputar = filmYangDiputar;
    }

    public int getJumlahPenonton() {
        return jumlahPenonton;
    }
}