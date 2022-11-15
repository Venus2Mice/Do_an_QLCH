package Repository;

import java.util.Arrays;
import Book.Book;

public class BookList {
    private static Book booklist[];

    public BookList() {
        booklist = new Book[3];
        booklist[0] = new Book(
                "300 bai code thieu nhi",
                "sach day code cho dan moi lap trinh",
                "Ga cung hoc duoc lap trinh",
                "Internet",
                "Internet",
                2000,
                1,
                197564133,
                12000.575f);
        booklist[1] = new Book(
                "Sach day lap trinh C",
                "Hoc ngon ngu lap trinh C",
                "Ngon ngu lap trinh C",
                "Internet",
                "Internet",
                2000,
                2,
                32137123,
                75000.125f);
        booklist[2] = new Book(
                "Asp.net core mvc to build your website",
                "sach day lap trinh web voi asp.net core mvc",
                "Asp.net core mvc",
                "unknow",
                "Tom and Jone",
                2005,
                3,
                123143,
                125000f);
    }

    // select toan bo mang
    public Book[] Select() {
        return booklist;
    }

    // select theo id
    public Book Select(int id) {
        for (Book book : booklist) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // select theo tu khoa tra ve mang cac cuon sach chua tu khoa
    public Book[] Select(String key) {
        Book temp[] = new Book[0];
        key = key.toLowerCase();
        for (Book book : booklist) {
            var logic = book.getBookName().toLowerCase().contains(key) ||
                    book.getDescription().toLowerCase().contains(key) ||
                    book.getPublisher().toLowerCase().contains(key) ||
                    book.getTitle().toLowerCase().contains(key);
            if (logic) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = book;
            }
        }
        return temp;
    }

    // add book to array
    public void insertBook(Book newBook) {
        boolean found = false;
        if (Select(newBook.getBookName()).length > 0) {
            found = true;
        }
        if (!found) {
            booklist = Arrays.copyOf(booklist, booklist.length + 1);
            booklist[booklist.length - 1] = newBook;
        }
    }

    // remove book from array
    public boolean removeBook(int id) {
        for (int i = 0; i < booklist.length; i++) {
            if (booklist[i].getId() == id) {
                for (int j = i; j < booklist.length - 1; j++) {
                    booklist[j] = booklist[j + 1];
                }
                booklist = Arrays.copyOf(booklist, booklist.length - 1);
                return true;
            }
        }
        return false;
    }

    // sua thong tin 1 cuon sach
    public boolean updateBook(int id) {
        var b = Select(id);
        if (b == null)
            return false;
        b.SetBook();
        return true;
    }

    public void sort() {
        Arrays.sort(booklist);
    }
}