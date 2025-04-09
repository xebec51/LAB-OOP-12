package TUGAS_PRAKTIKUM_LAB_2;

class Person {
    private String name;       
    int age;
    boolean isMale;

    void setName(String name) {
        this.name = name;
    }
    String getName(){
        return name;
    }

    void setAge(int age) {
        this.age = age;
    }
    int getAge(){
        return age;
    }

    void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    String getGender(){
        return this.isMale ? "Laki-laki" : "Perempuan";
    }
}


public class No1 {
    public static void main(String[] args) {
        Person biodata = new Person();

        biodata.setName("Dalvyn");
        biodata.setAge(19);
        biodata.setGender(true);
        System.out.println(biodata.getName());
        System.out.println(biodata.getAge());
        System.out.println(biodata.getGender());
    }
}
