package DangNhap;

public class Account {
    private String userName;
    public String getUserName() {
        return userName;
    }
    
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public Account() {
    }
    
    
}
