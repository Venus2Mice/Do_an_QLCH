package Views;

import Book.Book;

public class BookListView {
    private Book[] Models;

    public BookListView(Book[] models) {
        Models = models;
    }

    public void Render() {
        if (Models.length == 0) {
            System.out.println("Danh sach rong!!!");
            return;
        }
        System.out.println("\t\t\t\t\t\t\tDanh sach cac cuon sach:");
        for (Book book : Models) {
            new BookInfoView(book).Render();
            System.out.println();
        }
    }
}
