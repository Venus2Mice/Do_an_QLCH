package Models;

public class Book {

    private String bookName = "Unknown";

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    private String description = "Unknown";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String title = "Unknown";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String publisher = "Unknown publisher";

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    private String authors = "Unkown authors";

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    private int year = 2000;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int editon = 1;

    public int getEditon() {
        return editon;
    }

    public void setEditon(int editon) {
        this.editon = editon;
    }

    private int isbn = 978;

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

    private float price = 0.0f;

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
}
