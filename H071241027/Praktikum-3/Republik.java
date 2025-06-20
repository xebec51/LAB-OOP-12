import java.util.ArrayList;

public class Republik {
    String namaNegara;
    ArrayList<Menteri> daftarMenteri;
    ArrayList<Kementerian> daftarKementerian;

    public Republik(String nama) {
        this.namaNegara = nama;
        this.daftarMenteri = new ArrayList<>();
        this.daftarKementerian = new ArrayList<>();
    }

    public void tambahMenteri(Menteri menteri) {
        for (Menteri m : daftarMenteri) {
            if (m.getNama().equalsIgnoreCase(menteri.getNama())) {
                System.out.println("Menteri sudah terdaftar.");
                return;
            }
        }
        daftarMenteri.add(menteri);
        System.out.println("Menteri " + menteri.getNama() + " resmi menjabat.");
    }

    public void tambahKementerian(Kementerian kementerian) {
        daftarKementerian.add(kementerian);
        System.out.println("Kementerian " + kementerian.nama + " berhasil ditambahkan.");
    }

    public void angkatMenteri(Menteri menteri, Kementerian kementerian) {
        if (!daftarMenteri.contains(menteri)) {
            System.out.println("Menteri belum terdaftar.");
            return;
        }

        if (kementerian.status == Kementerian.StatusKementerian.AKTIF) {
            menteri.kementerian = kementerian;
            System.out.println("Menteri " + menteri.getNama() + " kini memimpin " + kementerian.nama);
        } else {
            System.out.println("Kementerian tidak aktif.");
        }
    }

    public void tampilkanData() {
        System.out.println("\n=== Pemerintahan " + namaNegara + " ===");
        for (Menteri m : daftarMenteri) {
            m.displayInfo();
        }
    }

    public static void main(String[] args) {
        Republik indonesia = new Republik("Republik Indonesia");

        Kementerian kemendikbud = new Kementerian("KM001", "Kemendikbud", "Pendidikan", 1_000_000_000, Kementerian.StatusKementerian.AKTIF);
        Kementerian kemenkes = new Kementerian("KM002", "Kemenkes", "Kesehatan", 800_000_000, Kementerian.StatusKementerian.AKTIF);

        indonesia.tambahKementerian(kemendikbud);
        indonesia.tambahKementerian(kemenkes);

        Menteri nadiem = new Menteri("Nadiem Makarim", "Pendidikan", 95.0);
        nadiem.tambahStaff("Raka");
        nadiem.tambahStaff("Yuni");

        Menteri budi = new Menteri("Budi Gunadi", "Kesehatan", 88.5);
        budi.tambahStaff("Lina");

        indonesia.tambahMenteri(nadiem);
        indonesia.tambahMenteri(budi);

        indonesia.angkatMenteri(nadiem, kemendikbud);
        indonesia.angkatMenteri(budi, kemenkes);

        indonesia.tampilkanData();
    }
}
