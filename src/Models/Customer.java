package Models;

public class Customer extends User {

    @Override
    public void setAuthorization() {
        super.authorization = "Customer";
    }

    public Customer(String name, int age) {
        setAuthorization();
        setName(name);
        setAge(age);
    }

}
