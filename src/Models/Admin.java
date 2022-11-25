package Models;

public class Admin extends User {

    @Override
    public void setAuthorization() {
        authorization = "Admin";
    }

    
    
}
