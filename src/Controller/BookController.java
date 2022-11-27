package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Models.Book;
import Repository.*;
import Views.*;
import netscape.javascript.JSObject;

public class BookController {
    public BookRepo list;

    public BookController(IDataAccess data) {
        list = new BookRepo(data);
    }

    public void List() {
        var models = list.Select();
        new BookListView(models).Render();
    }

    public void Insert() {
        var model = new Book();
        new BookCreateView(model).Render();
        list.insertBook(model);
    }

    public void Update(int id) {
        var model = list.Select(id);
        new BookUpdateView(model).Render();
        list.updateBook(model, id);
    }

    public void Delete(int id) {
        list.removeBook(id);
    }

    public void Search(int id) {
        var model = list.Select(id);
        new BookInfoView(model).Render();
    }

    public void Search(String key) {
        var models = list.Select(key);
        new BookListView(models).Render();
    }
    public void Sort (){
        list.sort();
        var models = list.Select();
        new BookListView(models);
    }
    public void GhiFile(String path) throws IOException {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            var tmp = list.Select();
            bw.write(tmp.length + "");
            bw.newLine();
            for (Book book : tmp) {
                bw.write(book.getAuthors() + ";");
                bw.write(book.getBookName() + ";");
                bw.write(book.getDescription() + ";");
                bw.write(book.getEditon() + ";");
                bw.write(book.getId() + ";");
                bw.write(book.getIsbn() + ";");
                bw.write(book.getPublisher() + ";");
                bw.write(book.getTitle() + ";");
                bw.write(book.getYear() + ";");
                bw.write(book.getPrice() + ";");
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
