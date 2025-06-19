public class Wizard extends Hero {
    public Wizard (String name, int health, int attackPower){
        super(name, health, attackPower);
    }
    @Override
    public void serang(){
        System.out.println(name + " memberikan mantra sihir sebanyak: " + attackPower);
    }
}
