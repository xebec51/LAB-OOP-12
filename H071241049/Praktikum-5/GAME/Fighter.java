public class Fighter extends Hero {
    public Fighter(){
        this("petarung", 120, 20);
    }
    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    @Override
    public void serang(){
        System.out.println(name + " menghantam musuh dgn kekuatan: ");
    }
}
