package Repository;

import Models.Admin;
import Models.Customer;
import Models.User;

public class UserData implements IDataAccess {
    private User Users[];

    public void Load() {
        Users = new User[3];
        Users[0] = new Admin("Nguyen Hoang Luan", 19);
        Users[1] = new Customer("Nguyen Thanh Long", 19);
        Users[2] = new Customer("Nguyen Hoang Nam", 19);
    }

    @Override
    public Object[] get() {
        // TODO Auto-generated method stub
        return Users;
    }
}
