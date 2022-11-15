import Controller.BookController;
import Help.Help;
import Repository.*;
import Views.*;

public class App {
    public static void main(String[] args) throws Exception {
        Data data = new Data();
        BookController controller = new BookController(data);
        while(true){
            BookView view = new BookView();
            view.onLoadBook();
            switch(Help.inputInt("Nhap lua chon:")){
                case 1 ->{
                    controller.Insert();
                }
                case 2->{
                    controller.Delete(Help.inputInt("Nhap id cuon sach can xoa: "));
                }
                case 3->{
                    controller.Update(Help.inputInt("nhap id cuon sach can sua:"));
                }
                case 4->{
                    controller.Search(Help.inputString("Nhap tu khoa: "));
                }
                case 5->{
                    
                }
                case 6->{
                    controller.List();
                }
            }
        }
    }
}
