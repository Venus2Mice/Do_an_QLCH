package Views;

import Framework.ViewHelp;
import Models.Book;

public class BookCreateView {
    private Book Model;

    public BookCreateView(Book model) {
        Model = model;
    }

    public void Render() {
        System.out.println(">>>> Nhap thong tin cho cuon sach:");
        Model.setBookName(ViewHelp.inputString("> Ten sach : "));
        Model.setAuthors(ViewHelp.inputString("> Tac gia : "));
        Model.setDescription(ViewHelp.inputString("> Mo Ta : "));
        Model.setEditon(ViewHelp.inputInt("> Tai ban: "));
        Model.setIsbn(ViewHelp.inputInt("> Ma isbn:"));
        Model.setPublisher(ViewHelp.inputString("> Ten nxb:"));
        Model.setTitle(ViewHelp.inputString("> Tieu de:"));
        Model.setPrice(ViewHelp.inputFloat("> Gia: "));
        Model.setYear(ViewHelp.inputInt("> Nam xuat ban:"));
    }
}
