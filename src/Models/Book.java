package Models;

public class Book {

    protected String bookName = "Unknown";

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    protected String description = "Unknown";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected String title = "Unknown";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected String publisher = "Unknown publisher";

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected String authors = "Unkown authors";

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    protected int year = 2000;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    protected int editon = 1;

    public int getEditon() {
        return editon;
    }

    public void setEditon(int editon) {
        this.editon = editon;
    }

    protected int isbn = 978;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    protected int id = 0;
    protected static int stt = 0;

    public int getId() {
        return id;
    }

    protected float price = 0.0f;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Book(String bookName, String description, String title, String publisher, String authors, int year,
            int editon, int isbn, float price) {
        setBookName(bookName);
        setDescription(description);
        setTitle(title);
        setPublisher(publisher);
        setAuthors(authors);
        setYear(year);
        setEditon(editon);
        setIsbn(isbn);
        setPrice(price);
        id += stt;
        stt++;
    }

    public Book() {
        id += stt;
        stt++;
    }
}
