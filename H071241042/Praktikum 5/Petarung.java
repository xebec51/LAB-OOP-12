public class Petarung extends Hero{
    public Petarung(String name){
        super(name, 80, 15);
    }
    @Override
    public void serang(){
        System.out.println(name + " memanah dengan kekuatan " + attackPower);
    }
}
