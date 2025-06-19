import java.util.Scanner;
class Person {
    String name;
    int age;
    boolean isMale;

    //atur nama
    void setName(String newName) {
        name = newName;
    }
    String getName() {
        return name;
    }

    void setAge(int newAge) {
        age = newAge;
    }
    int getAge() {
        return age;
    }

    void setGender(boolean gender) {
        isMale = gender;
    }

    String getGender() {
        if (isMale) {
            return "Male";
        } else {
            return "Female";
        }
    }
}

public class NO1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Person person = new Person(); //buat objek dari class

        System.out.println("Masukkan nama: ");
        person.setName(scan.nextLine());
        System.out.println("Masukkan umur: ");
        person.setAge(scan.nextInt());
        System.out.println("Apakah anda laki laki? (true/false)");
        person.setGender(scan.nextBoolean());

        System.out.println("----------------------");

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());

        scan.close();
    }
}