package Models;

public abstract class User {
    protected String name = "unknow";
    protected int age = 18;
    protected int id;
    protected String authorization;
    protected Account account = new Account();

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account.setUserName(account.getUserName());
        this.account.setPassword(account.getPassword());
        this.account.setAuthorization(getAuthorization());
    }

    public String getAuthorization() {
        return authorization;
    }

    protected abstract void setAuthorization();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
