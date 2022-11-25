package Models;

public class Admin extends User {

    @Override
    protected void setAuthorization() {
        authorization = "Admin";
    }

    public Admin(String name, int age, int id, Account account) {
        setAuthorization();
        setAge(age);
        setName(name);
        setId(id);
        setAccount(account);
    }

    public Admin() {
        setAccount(new Account());
    }

}
