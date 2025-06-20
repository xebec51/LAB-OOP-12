class Person {
    String name;
    int age;
    boolean isMale;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String getisMale() {
        if (isMale){
            return "Male";
        }
        else{
            return"Female";
        }
    }

    public void setMale(String isMale) {
        if (isMale.equals("Male")){
            this.isMale = true;
       }
       else{
            this.isMale = false;
       }
    }

}
public class TP2_Soal1 {


    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Pareddd");
        person.setAge(18);
        person.setMale("Male");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getisMale());
    }
}