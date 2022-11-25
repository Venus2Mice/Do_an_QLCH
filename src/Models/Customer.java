package Models;

public class Customer extends User {

    @Override
    public void setAuthorization() {
        super.authorization = "Customer";
    }

    
    
    
}
