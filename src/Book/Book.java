package Book;

import Help.Help;

public class Book {

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String publisher;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    private String authors;

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int editon;

    public int getEditon() {
        return editon;
    }

    public void setEditon(int editon) {
        this.editon = editon;
    }

    private int isbn;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    private int id = 0;
    private static int stt = 0;

    public int getId() {
        return id;
    }

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Book(String bookName, String description, String title, String publisher, String authors, int year,
            int editon, int isbn, float price) {
        this.bookName = bookName;
        this.description = description;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
        this.year = year;
        this.editon = editon;
        this.isbn = isbn;
        this.price = price;
        id += stt;
        stt++;
    }

    public Book() {
        id += stt;
        stt++;
    }

    public void RenderBook() {
        System.out.println(">>>> Book detail:");
        System.out.println("> Id : " + getId());
        System.out.println("> Ten sach : " + getBookName());
        System.out.println("> Tieu de : " + getTitle());
        System.out.println("> Ten tac gia : " + getAuthors());
        System.out.println("> Mo ta : " + getDescription());
        System.out.println("> Lan tai ban: " + getEditon());
        System.out.println("> Nha xuat ban: " + getPublisher());
        System.out.println("> Gia : " + getPrice() + ".vnd");
        System.out.println("> Nam xuat ban : " + getYear());
        System.out.println("> Ma isbn : " + getIsbn());
    }

    public void SetBook() {
        this.setBookName(Help.inputString("> Ten sach : "));
        this.setAuthors(Help.inputString("> Tac gia : "));
        this.setDescription(Help.inputString("> Mo Ta : "));
        this.setEditon(Help.inputInt("> Tai ban: "));
        this.setIsbn(Help.inputInt("> Ma isbn:"));
        this.setPublisher(Help.inputString("> Ten nxb:"));
        this.setTitle(Help.inputString("> Tieu de:"));
        this.setPrice(Help.inputFloat("> Gia: "));
        this.setYear(Help.inputInt("> Nam xuat ban:"));
    }
}
