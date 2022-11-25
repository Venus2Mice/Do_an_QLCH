package Controller;

import Repository.*;


public class UserController {
    private UserRepo list;

    public UserController(UserData context) {
        list = new UserRepo(context);
    }

}
