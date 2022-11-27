package Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import Framework.ControllerAction;
import Framework.Parameter;
import Framework.Router;
import Framework.ViewHelp;
import Models.Book;
import Models.User;

public class UserAuthorization {
    private User Model;
    private BookController bookController;
    private UserController userController;
    private HoaDonController hoaDonController;
    Book tmp[] = new Book[0];// mang tam luu san pham vao gio hang trc khi luu hoa don

    public UserAuthorization(User model, BookController bookController, UserController userController,
            HoaDonController hoaDonController) {
        Model = model;
        this.bookController = bookController;
        this.userController = userController;
        this.hoaDonController = hoaDonController;
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
        Router r = Router.Instance();
        r.Register("BookInsert", p -> bookController.Insert(), null);
        r.Register("BookDelete", p -> bookController.Delete(ViewHelp.inputInt("Nhap id cuon sach can xoa: ")), null);
        r.Register("BookUpdate", p -> bookController.Update(ViewHelp.inputInt("nhap id cuon sach can sua:")), null);
        r.Register("BookSearch", p -> bookController.Search(ViewHelp.inputString("Nhap tu khoa: ")), null);
        r.Register("BookList", p -> bookController.List(), null);
        r.Register("UserInsert", p -> userController.Insert(ViewHelp.inputString("Nhap loai user(admin/customer)")),
                null);
        r.Register("UserDelete", p -> userController.Delete(ViewHelp.inputInt("Nhap id cuon sach can xoa: ")), null);
        r.Register("UserUpdate", p -> userController.Update(ViewHelp.inputInt("nhap id cuon sach can sua:")), null);
        r.Register("UserSearch", p -> userController.Search(ViewHelp.inputString("Nhap tu khoa: ")), null);
        r.Register("UserList", p -> userController.List(), null);
        r.Register("HoaDon", p -> hoaDonController.List(), null);
        r.Register("Help", p -> System.out.println(r.GetRoutes()), null);
        while (true) {
            String req = ViewHelp.inputString(">>>Request : ");
            if (req.trim().toLowerCase().equals("exit"))
                return;
            Router.Instance().Forward(req);
            System.out.println("");
        }
    }

    private void CustomerController() throws Exception {
        Router r = Router.Instance();

        r.Register("Search", p -> bookController.Search(ViewHelp.inputString("Nhap tu khoa: ")), null);
        r.Register("List", p -> bookController.List(), null);
        r.Register("Help", p -> System.out.println(r.GetRoutes()), null);
        r.Register("addToCart", new ControllerAction<Parameter>() {

            @Override
            public void action(Parameter t) {

                var newBook = bookController.list.Select(ViewHelp.inputInt("Nhap id cuon sach can them : "));
                tmp = Arrays.copyOf(tmp, tmp.length + 1);
                tmp[tmp.length - 1] = newBook;

            }

        }, null);
        r.Register("Buy", new ControllerAction<Parameter>() {
            @Override
            public void action(Parameter t) {

                var makhachhang = Model.getId();
                LocalDate ngaymua = java.time.LocalDate.now();
                UUID uuid = UUID.randomUUID();
                var mahoadon = uuid.toString();
                double thanhtien = 0;
                for (Book book : tmp) {
                    thanhtien += book.getPrice();
                }
                hoaDonController.Insert(makhachhang, mahoadon, ngaymua, thanhtien, tmp);
            }
        }, null);
        r.Register("Xem Don Hang", new ControllerAction<Parameter>() {

            @Override
            public void action(Parameter t) {
                hoaDonController.Search(Model.getId());
                return;
            }

        }, null);
        while (true) {
            String req = ViewHelp.inputString(">>>Request : ");

            if (req.trim().toLowerCase().equals("exit"))
                return;
            Router.Instance().Forward(req);
            System.out.println("");
        }

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
