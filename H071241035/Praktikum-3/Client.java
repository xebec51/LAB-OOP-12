package TUGAS_PRAKTIKUM_LAB_3.Cekrek_Studio;  

public class Client {  
    private String nama;  
    private String jenisSesi;  
    private int durasiShooting;  

    public Client() {  
        this.nama = "";  
        this.jenisSesi = "";  
        this.durasiShooting = 0;  
    }  
   
    public Client(String nama, String jenisSesi, int durasiShooting) {  
        this.nama = nama;  
        this.jenisSesi = jenisSesi;  
        this.durasiShooting = durasiShooting;  
    }  

    public void requestSesi() {  
        System.out.println(nama + " meminta sesi foto jenis " +
         jenisSesi + " dengan durasi " + durasiShooting + " jam.");  
    }  

    public String getNama() {  
        return nama;  
    }  

    public String getJenisSesi() {  
        return jenisSesi;  
    }  

    public int getDurasiShooting() {  
        return durasiShooting;  
    }  
}  