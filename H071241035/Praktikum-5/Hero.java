package TUGAS_PRAKTIKUM_LAB_5;

public class Hero {
    protected String name;
    protected int health;
    protected int attackPower;

    // contruct
    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Method
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower +"!");
    }
}

