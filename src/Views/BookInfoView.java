package Views;

import Book.Book;

public class BookInfoView {
    private Book Model;

    public BookInfoView(Book model) {
        Model = model;
    }

    public void Render() {
        if (Model != null) {
            System.out.println(">>>> BOOK DETAIL INFORMATION:");
            System.out.println("> Id : "            + Model.getId());
            System.out.println("> Ten sach : "      + Model.getBookName());
            System.out.println("> Tieu de : "       + Model.getTitle());
            System.out.println("> Ten tac gia : "   + Model.getAuthors());
            System.out.println("> Mo ta : "         + Model.getDescription());
            System.out.println("> Lan tai ban: "    + Model.getEditon());
            System.out.println("> Nha xuat ban: "   + Model.getPublisher());
            System.out.println("> Gia : "           + Model.getPrice() + ".vnd");
            System.out.println("> Nam xuat ban : "  + Model.getYear());
            System.out.println("> Ma isbn : "       + Model.getIsbn());
        } else {
            System.out.println("Not found!");
        }
    }

}
