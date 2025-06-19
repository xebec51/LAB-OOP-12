public class Penyihir extends Hero{
    public Penyihir(String name){
        super(name, 80, 20);
    }
    @Override
    public void serang(){
        System.out.println(name + " memanah dengan kekuatan " + attackPower);
    }
}
