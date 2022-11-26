package Controller;

import Framework.ControllerAction;
import Framework.Parameter;
import Framework.Router;
import Framework.ViewHelp;
import Models.User;

public class UserAuthorization {
    private User Model;
    private BookController bookController;
    private UserController userController;

    public UserAuthorization(User model, BookController bookController, UserController userController) {
        Model = model;
        this.bookController = bookController;
        this.userController = userController;
    }

    private Boolean isAdmin() {
        if (Model.getAuthorization().equals("Admin")) {
            return true;
        }
        return false;
    }

    private Boolean isCustomer() {
        if (Model.getAuthorization().equals("Customer")) {
            return true;
        }
        return false;
    }

    private void AdminController() throws Exception {
        // while (true) {
        //     BookMNView view = new BookMNView();
        //     view.onLoadBook();
        //     switch (ViewHelp.inputInt("Nhap lua chon:")) {
        //         case 1 -> {
        //             bookController.Insert();
        //         }
        //         case 2 -> {
        //             bookController.Delete(ViewHelp.inputInt("Nhap id cuon sach can xoa: "));
        //         }
        //         case 3 -> {
        //             bookController.Update(ViewHelp.inputInt("nhap id cuon sach can sua:"));
        //         }
        //         case 4 -> {
        //             bookController.Search(ViewHelp.inputString("Nhap tu khoa: "));
        //         }
        //         case 5 -> {

        //         }
        //         case 6 -> {
        //             bookController.List();
        //         }
        //         case 7 -> {
        //             return;
        //         }
        //     }
        // }
         Router.Instance().Register("hi", new ControllerAction<Parameter>() {

            @Override
            public void action(Parameter t) {
                System.out.println("hello ok ok");
                
            }
            
        }, null);
        var c = Router.Instance();
        System.out.println(Router.Instance().GetRoutes());    

        while(true){
            System.out.println("nhap:");
            String req = ViewHelp.inputString();
            Router.Instance().Forward(req);
        }

    }

    private void CustomerController() {

    }

    public void Render() throws Exception {
        if (isAdmin()) {
            AdminController();
        } else if (isCustomer()) {
            CustomerController();
        } else {
            return;
        }
    }

}
