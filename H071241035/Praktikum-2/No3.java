package TUGAS_PRAKTIKUM_LAB_2;

class Cuboid {  
    double height;  
    double width;  
    double length;  

    //method
    double getVolume() {  
        return height * width * length;  
    }  
}

public class No3 {  
    public static void main(String[] args) {  
        //objek
        Cuboid cuboid = new Cuboid();  
        cuboid.height = 30;  
        cuboid.width = 15;  
        cuboid.length = 10;  
        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));  
    }  
}  
