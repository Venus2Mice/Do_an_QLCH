package Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Models.Book;

public class FileBook implements IDataAccess {
    private Book list[];

    @Override
    public Object[] get() {
        // TODO Auto-generated method stub
        return list;
    }

    @Override
    public void Load() {

    }

    public void DocFile() throws IOException {
        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        var n = br.readLine();
        list = new Book[Integer.parseInt(n)];
        String sr;
        for (int i = 0; i < list.length; i++) {
            sr = br.readLine();
            if (sr == null)
                break;
            var tmp = sr.split(";");
            list[i] = new Book();
            list[i].setAuthors(tmp[0]);
            list[i].setBookName(tmp[1]);
            list[i].setDescription(tmp[2]);
            list[i].setEditon(Integer.parseInt(tmp[3]));
            list[i].setIsbn(Integer.parseInt(tmp[5]));
            list[i].setPublisher(tmp[6]);
            list[i].setTitle(tmp[7]);
            list[i].setYear(Integer.parseInt(tmp[8]));
            list[i].setPrice(Float.parseFloat(tmp[9]));

        }
    }

}
