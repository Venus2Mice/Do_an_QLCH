package Repository;

import java.util.Arrays;

import Models.User;

public class UserRepo {
    public User UserList[];

    public UserRepo(IDataAccess context) {
        context.Load();
        UserList = (User[]) context.get();
    }

    public User[] Select() {
        return UserList;
    }

    // select theo id
    public User Select(int id) {
        for (User User : UserList) {
            if (User.getId() == id) {
                return User;
            }
        }
        return null;
    }

    // select theo tu khoa tra ve mang cac cuon sach chua tu khoa
    public User[] Select(String key) {
        User temp[] = new User[0];
        key = key.toLowerCase();
        for (User User : UserList) {
            var logic = User.getName().toLowerCase().contains(key);
            if (logic) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = User;
            }
        }
        return temp;
    }

    // add User to array
    public void insertUser(User newUser) {
        boolean found = false;
        if (Select(newUser.getName()).length > 0) {
            found = true;
        }
        if (!found) {
            UserList = Arrays.copyOf(UserList, UserList.length + 1);
            UserList[UserList.length - 1] = newUser;
        }
    }

    // remove User from array
    public boolean removeUser(int id) {
        for (int i = 0; i < UserList.length; i++) {
            if (UserList[i].getId() == id) {
                for (int j = i; j < UserList.length - 1; j++) {
                    UserList[j] = UserList[j + 1];
                }
                UserList = Arrays.copyOf(UserList, UserList.length - 1);
                return true;
            }
        }
        return false;
    }

    // sua thong tin 1 cuon sach
    public boolean updateUser(User newUser, int id) {
        var b = Select(id);
        if (b == null)
            return false;
        b = newUser;
        return true;
    }

    public void sort() {
        Arrays.sort(UserList);
    }
}
