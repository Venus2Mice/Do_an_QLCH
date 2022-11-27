package Controller;

import Models.Admin;
import Models.Customer;
import Models.User;
import Repository.*;
import Views.UserCreateView;
import Views.UserInfoView;
import Views.UserListView;
import Views.UserUpdateView;

public class UserController {
    private UserRepo list;

    public UserController(IDataAccess context) {
        list = new UserRepo(context);
    }

    public void Insert(String user){
        switch(user.trim().toLowerCase()){
            case "admin"->{
                User model = new Admin();
                new UserCreateView(model).Render();
                list.insertUser(model);
            }
            case "customer"->{
                User model = new Customer();
                new UserCreateView(model).Render();
                list.insertUser(model);
            }
        }
    }

    public void List() {
        var models = list.Select();
        new UserListView(models).Render();
    }

    public void Update(int id) {
        var model = list.Select(id);
        new UserUpdateView(model).Render();
        list.updateUser(model, id);
    }

    public void Delete(int id) {
        list.removeUser(id);
    }

    public void Search(int id) {
        var model = list.Select(id);
        new UserInfoView(model).Render();
    }

    public void Search(String key) {
        var models = list.Select(key);
        new UserListView(models).Render();
    }
}
