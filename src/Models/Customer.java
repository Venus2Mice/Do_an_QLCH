package Models;

public class Customer extends User {
    private String description = "";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setAuthorization() {
        super.authorization = "Customer";
    }

    public Customer(String name, int age, int id, Account account, String description) {
        setAuthorization();
        setAge(age);
        setName(name);
        setId(id);
        setAccount(account);
        setDescription(description);
    }

    public Customer() {
        setAccount(new Account());
    }

}
