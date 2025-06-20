class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height * width * length; // Menghitung volume balok
    }
}

public class no3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        
        //Mengisi nilai dari tinggi, lebar dan panjang
        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30;

        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}
