public class no1_H071241042 {
    String name;
	int age;
	boolean isMale;

	public void setName(String name)		{ this.name = name;} // *this : untk membedakan variabel lokal dan atribut
	public String getName()					{ return name;}

	public void setAge(int age)				{ this.age = age;}
	public int getAge()						{ return age;}

	public void setGender(boolean isMale)	{ this.isMale = isMale;}
	public String getGender()				{ return isMale ? "Laki-laki" : "Perempuan";} // ternary

	public static void main(String[] args) {
		no1_H071241042 person = new no1_H071241042();
        person.setName("Kime");
        person.setAge(19);
        person.setGender(false);

        System.out.println("Name   : " + person.getName());
        System.out.println("Age    : " + person.getAge());
        System.out.println("Gender : " + person.getGender());
	}
  
}