package TUGAS_PRAKTIKUM_LAB_3.Cekrek_Studio;  

public class Photographer {  
    private String nama;  
    private int pengalamanTahun;  
    private Kamera kamera;  

    public Photographer() {  
        this.nama = "";  
        this.pengalamanTahun = 0;  
        this.kamera = null;  
    }  

    public Photographer(String nama, int pengalamanTahun, Kamera kamera) {  
        this.nama = nama;  
        this.pengalamanTahun = pengalamanTahun;  
        this.kamera = kamera;  
    }  

    public void fotoShoot(Client client) {  
        System.out.println(nama + " (" + pengalamanTahun + " tahun pengalaman) memulai sesi foto "   
            + client.getJenisSesi() + " selama " + client.getDurasiShooting() + " jam.");  
        if (kamera != null && kamera.cekKondisi()) {  
            kamera.ambilFoto();  
            System.out.println("Sesi foto dengan " + client.getNama() + " selesai.");  
        } else {  
            System.out.println("Kamera tidak dalam kondisi baik. Sesi foto dibatalkan.");  
        }  
    }   

    public void editFoto() {  
        System.out.println(nama + " sedang mengedit foto hasil sesi.");  
    }  

    public void compareExperience(Photographer other) {  
        if (this.pengalamanTahun > other.pengalamanTahun) {  
            System.out.println(this.nama + " lebih berpengalaman daripada " + other.nama);  
        } else if (this.pengalamanTahun < other.pengalamanTahun) {  
            System.out.println(other.nama + " lebih berpengalaman daripada " + this.nama);  
        } else {  
            System.out.println(this.nama + " dan " + other.nama + " memiliki pengalaman yang sama.");  
        }  
    }  
}  