package Repository;

import Models.Account;
import Models.Admin;
import Models.Customer;
import Models.User;

public class UserData implements IDataAccess {
    private User Users[];

    public void Load() {
        Users = new User[3];
        Users[0] = new Admin(
                "Nguyen Hoang Luan",
                19,
                31215,
                new Account(
                        "Luan123",
                        "123456",
                        "Admin"));
        Users[1] = new Customer(
                "Nguyen Hoang Long",
                19,
                31652,
                new Account(
                        "Long123",
                        "123456",
                        "Customer"),
                "Khach hang than quen");
        Users[2] = new Customer();
    }

    @Override
    public Object[] get() {
        // TODO Auto-generated method stub
        return Users;
    }
}
