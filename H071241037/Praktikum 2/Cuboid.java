class  Cuboid{
    double height;
    double widht;
    double length;
    
    public double getVolume(){
        return height * widht * length;
    }

    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 10;
        cuboid.widht = 5;
        cuboid.length = 90;
        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}
