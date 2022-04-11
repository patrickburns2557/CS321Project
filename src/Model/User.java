package Model;

public class User {
    private String username;
    private String password;

    //Getter

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //Setter

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}