public class Archer extends Hero {
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    @Override
    public void serang(){
        System.out.println(name + " menembakkan dgn kekuatan: " + attackPower);
    }
}
