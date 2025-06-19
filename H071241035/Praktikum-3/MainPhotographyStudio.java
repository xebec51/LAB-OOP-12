package TUGAS_PRAKTIKUM_LAB_3.Cekrek_Studio;  

public class MainPhotographyStudio {  
    public static void main(String[] args) {  

        Kamera kamera1 = new Kamera("Nikon", "Z5 Mark 2", "Nikkor z50mm f/1.2");  
        Photographer fotografer1 = new Photographer("Dalvyn", 5, kamera1);  
        Photographer fotografer2 = new Photographer("Suhada", 3, kamera1);  

        Client client1 = new Client("Walid", "Prewedding 10x", 10);  
        fotografer1.compareExperience(fotografer2);
        System.out.println("---------------------------------------------------");
        client1.requestSesi();  

        System.out.println("---------------------------------------------------");
        fotografer1.fotoShoot(client1);  
        
        System.out.println("---------------------------------------------------");
        fotografer1.editFoto();  
 
    }  
}  