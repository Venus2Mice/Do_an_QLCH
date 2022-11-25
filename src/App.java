import Controller.BookController;
import Controller.UserController;
import Framework.Help;
import Repository.BookData;
import Repository.IDataAccess;
import Repository.UserData;
import Views.BookView;

public class App {
    public static void main(String[] args) throws Exception {
        IDataAccess context = new BookData();
        BookController controller = new BookController(context);
        while (true) {
            BookView view = new BookView();
            view.onLoadBook();
            switch (Help.inputInt("Nhap lua chon:")) {
                case 1 -> {
                    controller.Insert();
                }
                case 2 -> {
                    controller.Delete(Help.inputInt("Nhap id cuon sach can xoa: "));
                }
                case 3 -> {
                    controller.Update(Help.inputInt("nhap id cuon sach can sua:"));
                }
                case 4 -> {
                    controller.Search(Help.inputString("Nhap tu khoa: "));
                }
                case 5 -> {

                }
                case 6 -> {
                    controller.List();
                }
                case 7 -> {
                    return;
                }
            }
        }
        // IDataAccess context = new UserData();
        // UserController controller = new UserController(context);
        // controller.List();
        // controller.Search("Luan");
    }
}
