package TUGAS_PRAKTIKUM_LAB_5;

public class Wizard extends Hero {

    //construct
    public Wizard(String name) {
        super(name, 80, 20); 
    }
    
    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan sihir, kekuatan serangannya: " + attackPower);
    }
}
