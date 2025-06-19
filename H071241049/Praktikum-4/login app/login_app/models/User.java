package login_app.models;

public class User {
    private String username;
    private String password;
//kons utk objek baru
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
