import Repository.BookList;
import Views.BookView;

public class App {
    public static void main(String[] args) throws Exception {
        
        BookList list = new BookList();
        BookView view = new BookView(list);
        while(true){
            view.Render();
        }
    }
}
