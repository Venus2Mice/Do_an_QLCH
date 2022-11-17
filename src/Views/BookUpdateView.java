package Views;

import Book.Book;
import Help.Help;

public class BookUpdateView {
    private Book Model;

    public BookUpdateView(Book model) {
        Model = model;
    }

    public void Render() {
        System.out.println(">>>> UPDATE BOOK INFORMATION");
        Model.setBookName(Help.inputString("> Ten sach : ", Model.getBookName()));
        Model.setAuthors(Help.inputString("> Tac gia : ", Model.getAuthors()));
        Model.setDescription(Help.inputString("> Mo Ta : ", Model.getDescription()));
        Model.setEditon(Help.inputInt("> Tai ban: ", Model.getEditon()));
        Model.setIsbn(Help.inputInt("> Ma isbn:", Model.getIsbn()));
        Model.setPublisher(Help.inputString("> Ten nxb:", Model.getPublisher()));
        Model.setTitle(Help.inputString("> Tieu de:", Model.getTitle()));
        Model.setPrice(Help.inputFloat("> Gia: ", Model.getPrice()));
        Model.setYear(Help.inputInt("> Nam xuat ban:", Model.getYear()));
    }
}
