public class Pemanah extends Hero {

    public Pemanah(String name){
        super(name, 80, 25);
    }
    @Override
    public void serang(){
        System.out.println(name + " memanah dengan kekuatan " + attackPower);
    }

}
