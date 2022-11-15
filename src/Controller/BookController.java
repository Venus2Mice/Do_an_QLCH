package Controller;

import Book.Book;
import Repository.*;
import Views.*;

public class BookController {
    private BookRepo list;

    public BookController(Data data) {
        list = new BookRepo(data);
    }

    public void List() {
        var models = list.Select();
        new BookListView(models).Render();
    }
    public void Insert() {
        var model = new Book();
        model = new BookCreateView(model).get();
        list.insertBook(model);
    }
    public void Update(int id) {
        var model = list.Select(id);
        model = new BookUpdateView(model).get(); 
        list.updateBook(model,id);
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
        new BookListView(models).Render();;
    }
}
