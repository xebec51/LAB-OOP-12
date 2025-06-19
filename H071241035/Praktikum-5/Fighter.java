package TUGAS_PRAKTIKUM_LAB_5;

public class Fighter extends Hero {

    // construct
    public Fighter(String name) {
        this(name, 120, 18); 
    }

    // construct
    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower); 
    }
}
