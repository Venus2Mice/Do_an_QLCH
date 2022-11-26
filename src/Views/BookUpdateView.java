package Views;

import Framework.ViewHelp;
import Models.Book;

public class BookUpdateView {
    private Book Model;

    public BookUpdateView(Book model) {
        Model = model;
    }

    public void Render() {
        System.out.println(">>>> UPDATE BOOK INFORMATION");
        Model.setBookName(ViewHelp.inputString("> Ten sach : ", Model.getBookName()));
        Model.setAuthors(ViewHelp.inputString("> Tac gia : ", Model.getAuthors()));
        Model.setDescription(ViewHelp.inputString("> Mo Ta : ", Model.getDescription()));
        Model.setEditon(ViewHelp.inputInt("> Tai ban: ", Model.getEditon()));
        Model.setIsbn(ViewHelp.inputInt("> Ma isbn:", Model.getIsbn()));
        Model.setPublisher(ViewHelp.inputString("> Ten nxb:", Model.getPublisher()));
        Model.setTitle(ViewHelp.inputString("> Tieu de:", Model.getTitle()));
        Model.setPrice(ViewHelp.inputFloat("> Gia: ", Model.getPrice()));
        Model.setYear(ViewHelp.inputInt("> Nam xuat ban:", Model.getYear()));
    }
}
