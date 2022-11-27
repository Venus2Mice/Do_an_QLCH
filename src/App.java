import Controller.BookController;
import Controller.HoaDonController;
import Controller.LogInController;
import Controller.UserAuthorization;
import Controller.UserController;
import Framework.Router;
import Framework.ViewHelp;
import Models.User;
import Repository.BookData;
import Repository.HoaDonData;
import Repository.IDataAccess;
import Repository.UserData;

public class App {
    public static void main(String[] args) throws Exception {
        IDataAccess user_context = new UserData();
        UserController user_controller = new UserController(user_context);
        IDataAccess book_context = new BookData();
        BookController book_controller = new BookController(book_context);
        IDataAccess hoadon_context = new HoaDonData();
        HoaDonController hoaDonController = new HoaDonController(hoadon_context);
        Router router = Router.Instance();
        while (true) {
            LogInController logInController = new LogInController((User[]) user_context.get());
            var x = logInController.Render();
            UserAuthorization userAuthorization = new UserAuthorization(x, book_controller, user_controller,
                    hoaDonController,router);
            userAuthorization.Render();
            var req = ViewHelp.inputString("Continute or exit : ");
            if (req.trim().toLowerCase().equals("exit"))
                return;
        }
    }
}
