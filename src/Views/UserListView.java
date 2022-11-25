package Views;

import Models.User;

public class UserListView {
    private User[] Models;

    public UserListView(User []models){
        Models=models;
    }

    public void Render(){
        if (Models.length == 0) {
            System.out.println("Danh sach rong!!!");
            return;
        }
        System.out.println("\t\t\t\t\t\t\tDanh sach cac cuon sach:");
        for (User book : Models) {
            new UserInfoView(book).Render();
            System.out.println();
        }
    }
}