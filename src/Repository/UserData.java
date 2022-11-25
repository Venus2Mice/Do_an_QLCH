package Repository;

import Models.Admin;
import Models.Customer;
import Models.User;

public class UserData {
    public User Users[];

    public void Load() {
        Users = new User[3];
        Users[0] = new Admin();
        Users[1] = new Customer();
        Users[2] = new Customer();
    }
}
