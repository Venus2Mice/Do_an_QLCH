package Controller;

import Framework.Help;
import Models.User;
import Views.BookView;

public class UserAuthorization {
    private User Model;
    private BookController bookController;
    private UserController userController;

    public UserAuthorization(User model, BookController bookController, UserController userController) {
        Model = model;
        this.bookController = bookController;
        this.userController = userController;
    }

    public Boolean isAdmin() {
        if (Model.getAuthorization().equals("Admin")) {
            return true;
        }
        return false;
    }

    public Boolean isCustomer() {
        if (Model.getAuthorization().equals("Customer")) {
            return true;
        }
        return false;
    }

    public void AdminController() {
        if (isAdmin()) {
            while (true) {
                BookView view = new BookView();
                view.onLoadBook();
                switch (Help.inputInt("Nhap lua chon:")) {
                    case 1 -> {
                        bookController.Insert();
                    }
                    case 2 -> {
                        bookController.Delete(Help.inputInt("Nhap id cuon sach can xoa: "));
                    }
                    case 3 -> {
                        bookController.Update(Help.inputInt("nhap id cuon sach can sua:"));
                    }
                    case 4 -> {
                        bookController.Search(Help.inputString("Nhap tu khoa: "));
                    }
                    case 5 -> {

                    }
                    case 6 -> {
                        bookController.List();
                    }
                    case 7 -> {
                        return;
                    }
                }
            }
        }
    }

    public void CustomerController() {
        if (isCustomer()) {

        }
    }

}
