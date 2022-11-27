package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    public void GhiFile(String path) throws IOException {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            var tmp = list.Select();
            bw.write(tmp.length + "");
            bw.newLine();
            for (User user : tmp) {
                bw.write("{");
                bw.newLine();
                bw.write(user.getName());
                bw.newLine();
                bw.write(user.getAge()+"");
                bw.newLine();
                bw.write(user.getId()+"");
                bw.newLine();
                var usname = user.getAccount().getUserName();
                var pass = user.getAccount().getPassword();
                bw.write(usname);
                bw.newLine();
                bw.write(pass);
                bw.newLine();
                if(user.getClass().getSimpleName().equals("Customer")){
                    var c = (Customer) user;
                    bw.write(c.getDescription());
                }
                bw.newLine();
                bw.write("},");
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
