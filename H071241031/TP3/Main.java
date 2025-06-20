public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Avengers: Endgame", "Action", 180);
        Film film2 = new Film("The Lion King", "Animation", 118);
    
        Bioskop bioskop1 = new Bioskop("CGV", 150, film1);
        Bioskop bioskop2 = new Bioskop("XXI", 200, film2);

        bioskop1.tambahPenonton(100);
        bioskop2.tambahPenonton(50);
        
        bioskop1.pindahkanPenontonKe(bioskop2, 30);
        
        bioskop1.displayInfo();
        System.out.println();
        bioskop2.displayInfo();
    }
}