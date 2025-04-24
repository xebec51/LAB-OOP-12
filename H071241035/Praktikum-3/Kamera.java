package TUGAS_PRAKTIKUM_LAB_3.Cekrek_Studio;  

public class Kamera {  
    private String merk;  
    private String model;  
    private String tipeLensa;  

    public Kamera() {  
        this.merk = "";  
        this.model = "";  
        this.tipeLensa = "";  
    }  

    public Kamera(String merk, String model, String tipeLensa) {  
        this.merk = merk;  
        this.model = model;  
        this.tipeLensa = tipeLensa;  
    }  

    public boolean cekKondisi() {    
        System.out.println("Kamera " + merk + " " + model + " dalam kondisi baik.");  
        return true;  
    }  

    public void ambilFoto() {  
        System.out.println("Mengambil foto menggunakan kamera " + merk + " model " + model + " dengan lensa " + tipeLensa + ".");  
    }  
}  