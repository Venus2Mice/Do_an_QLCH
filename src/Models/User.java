package Models;

public abstract class User {
    protected String name = "unknow";
    protected int age = 18;
    protected int id;
    protected String authorization;

    
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
