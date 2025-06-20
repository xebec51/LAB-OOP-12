package live_coding;


public class soal {
   public static void main(String[] args) {
        AkunPengguna p1 = new AkunPengguna("Fariid", "Awikwok123");
        System.out.println(p1.getUsername());
        System.out.println(p1.getPassword());
        AkunPengguna p2 = new AkunPengguna("Fared", "Awikwok124");
        System.out.println(p2.getUsername());
        System.out.println(p2.getPassword());
        System.out.println("jumlah akun yang login" + p1.getjumlahAkun());
        System.out.println("jumlah akun yang login" + p2.getjumlahAkun());

   }
}

class AkunPengguna {
    private String username;
    private final String password;
    private static int jumlahAkun;
    

    public AkunPengguna(String username, String password) {
        this.username = username;
        this.password = password;
        jumlahAkun++;
    }

    public void setUsername(String username) {
        this.username = username;

        
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public int getjumlahAkun() {
        return jumlahAkun;
    }

}

