package Models;

public class Admin extends User {

    @Override
    protected void setAuthorization() {
        authorization = "Admin";
    }

    public Admin(String name, int age) {
        setAuthorization();
        setAge(age);
        setName(name);
    }

}
