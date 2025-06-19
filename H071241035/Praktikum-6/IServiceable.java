import java.util.Date;

public interface IServiceable {
    
    boolean periksaKondisi();
    
    void lakukanServis();
    
    Date getWaktuServisBerikutnya = new Date();
    
    double hitungBiayaServis();
}