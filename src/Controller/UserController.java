package Controller;

import Repository.*;
import Views.UserInfoView;
import Views.UserListView;
import Views.UserUpdateView;

public class UserController {
    private UserRepo list;

    public UserController(IDataAccess context) {
        list = new UserRepo(context);
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
