package Views;

import Framework.Help;
import Models.Book;

public class BookCreateView {
    private Book Model;

    public BookCreateView(Book model) {
        Model = model;
    }

    public void Render() {
        System.out.println(">>>> Nhap thong tin cho cuon sach:");
        Model.setBookName(Help.inputString("> Ten sach : "));
        Model.setAuthors(Help.inputString("> Tac gia : "));
        Model.setDescription(Help.inputString("> Mo Ta : "));
        Model.setEditon(Help.inputInt("> Tai ban: "));
        Model.setIsbn(Help.inputInt("> Ma isbn:"));
        Model.setPublisher(Help.inputString("> Ten nxb:"));
        Model.setTitle(Help.inputString("> Tieu de:"));
        Model.setPrice(Help.inputFloat("> Gia: "));
        Model.setYear(Help.inputInt("> Nam xuat ban:"));
    }
}
