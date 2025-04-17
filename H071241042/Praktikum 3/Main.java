public class Main{
    public static void main(String[] args) {
        Topping T1 = new Topping("coklat", 5000);
        Topping T2 = new Topping("Keju", 6000);
        
        Kue K1 = new Kue("besar", 20000, T1);
        Kue K2 = new Kue("kecil", 20000, T2);

        Pembeli P1 = new Pembeli("Kime", K2);
        Pembeli P2 = new Pembeli("Indir", K1);

        System.out.println("Nama pembeli    : " + P1.nama);
        K1.tampilkanInfo();

        System.out.println();
        
        System.out.println("Nama pembeli    : " + P2.nama);
        K2.tampilkanInfo();
        
        System.out.println("---------------------------------");

        P1.bandingkanPembayaran(P2);
    }
}