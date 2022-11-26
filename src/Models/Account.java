package Models;

public class Account {
    private String userName = "none";

    public String getUserName() {
        return userName;
    }

    private String password = "none";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String authorization = "Customer";

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Account(String userName, String password, String authorization) {
        setPassword(password);
        setUserName(userName);
        setAuthorization(authorization);
    }

    public Account() {}

}
