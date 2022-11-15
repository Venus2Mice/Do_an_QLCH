package Views;
import Book.Book;
import Help.Help;
import Repository.BookList;

public class BookView {

    public BookView(BookList list) {
        this.list = list;
    }
    private BookList list;

    private int choice;
    public int getChoice() {
        return choice;
    }
    public void setChoice() {
        this.choice = Help.inputInt(">>> Choice:");
    }
    public void onLoadBook() {
        System.out.println("\t\t\t\t\t\t\tBOOK STORE MANAGEMENT SYSTEM");
            System.out.println("1. Insert Book.");
            System.out.println("2. Remove Book.");
            System.out.println("3. Update Book.");
            System.out.println("4. Search Book.");
            System.out.println("5. Sort.");
            System.out.println("6. Display list book.");
    }
    public void Insert() {
        Book book = new Book();
        book.SetBook();
        list.insertBook(book);
    }
    public void Remove() {
        list.removeBook(Help.inputInt(">> Nhap id cuon sach can xoa:"));
    }
    public void Update() {
        list.updateBook(Help.inputInt(">> Nhap id cuon sach can sua:"));
    }
    public void Search(){
        String input = Help.inputString(">> Nhap tu khoa:");
        var tmp = list.Select(input);
        Help.outputString(">>\t\t\t\t\t\t\tSearching...");
        if(tmp!=null)
        for (Book book : tmp) {
            book.RenderBook();
        }
        else{
            Help.outputString("Not Found!");
        }
    }
    public void DisplayListBook() {
        Help.outputString("\t\t\t\t\t\t\tDanh sach cac cuon sach:");
        var tmp = list.Select();
        if(tmp!=null)
        for (Book book : tmp) {
            book.RenderBook();
        }
        else{
            Help.outputString("Danh sach rong!");
        }
    }
    public void Render() {
        boolean flag = true;
        while(flag){
            onLoadBook();
            setChoice();
            switch (choice) {
                case 1 -> {
                    Insert();
                    flag=false;
                    break;
                }

                case 2 -> {
                    Remove();
                    flag=false;
                    break;
                }

                case 3 -> {
                    Update();
                    flag=false;
                    break;
                }

                case 4 -> {
                    Search();
                    flag=false;
                    break;
                }

                case 5 -> {

                }

                case 6 -> {
                    DisplayListBook();
                    flag=false;
                    break;
                } 
                
                default -> System.out.print("Nhap lai!");
            }
        }
    }

}
