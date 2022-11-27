package Controller;

import java.io.IOException;
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
    private Router router;

    public UserAuthorization(User model, BookController bookController, UserController userController,
            HoaDonController hoaDonController, Router router) {
        Model = model;
        this.bookController = bookController;
        this.userController = userController;
        this.hoaDonController = hoaDonController;
        this.router = router;
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

        router.ClearAll();
        router.Register("BookInsert", p -> bookController.Insert(), null);
        router.Register("BookDelete", p -> bookController.Delete(ViewHelp.inputInt("Nhap id cuon sach can xoa: ")),
                null);
        router.Register("BookUpdate", p -> bookController.Update(ViewHelp.inputInt("nhap id cuon sach can sua:")),
                null);
        router.Register("BookSearch", p -> bookController.Search(ViewHelp.inputString("Nhap tu khoa: ")), null);
        router.Register("BookList", p -> bookController.List(), null);
        router.Register("UserInsert",
                p -> userController.Insert(ViewHelp.inputString("Nhap loai user(admin/customer)")),
                null);
        router.Register("UserDelete", p -> userController.Delete(ViewHelp.inputInt("Nhap id cuon sach can xoa: ")),
                null);
        router.Register("UserUpdate", p -> userController.Update(ViewHelp.inputInt("nhap id cuon sach can sua:")),
                null);
        router.Register("UserSearch", p -> userController.Search(ViewHelp.inputString("Nhap tu khoa: ")), null);
        router.Register("UserList", p -> userController.List(), null);
        router.Register("HoaDon", p -> hoaDonController.List(), null);
        router.Register("Help", p -> System.out.println(router.GetRoutes()), null);
        router.Register("FileBook", p->{
            try {
                bookController.GhiFile(ViewHelp.inputString("Nhap Ten File : "));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, null);
        router.Register("FileUser", p->{
            try {
                userController.GhiFile(ViewHelp.inputString("Nhap Ten File : "));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, null);
        router.Register("FileHoaDon", p->{
            try {
                hoaDonController.GhiFile(ViewHelp.inputString("Nhap Ten File : "));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
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

    private void CustomerController() throws Exception {

        router.ClearAll();
        router.Register("Search", p -> bookController.Search(ViewHelp.inputString("Nhap tu khoa: ")), null);
        router.Register("List", p -> bookController.List(), null);
        router.Register("Help", p -> System.out.println(router.GetRoutes()), null);
        router.Register("addToCart", new ControllerAction<Parameter>() {

            @Override
            public void action(Parameter t) {

                var newBook = bookController.list.Select(ViewHelp.inputInt("Nhap id cuon sach can them : "));
                tmp = Arrays.copyOf(tmp, tmp.length + 1);
                tmp[tmp.length - 1] = newBook;

            }

        }, null);
        router.Register("Buy", new ControllerAction<Parameter>() {
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
        router.Register("Xem Don Hang", new ControllerAction<Parameter>() {

            @Override
            public void action(Parameter t) {
                hoaDonController.Search(Model.getId());
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
