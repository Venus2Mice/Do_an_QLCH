package Repository;

import Models.Book;

public class BookData implements IDataAccess{
    private Book Books[];
    public void Load(){
        Books = new Book[5];
        Books[0] = new Book(
            "300 bai code thieu nhi",
            "sach day code cho dan moi lap trinh",
            "Ga cung hoc duoc lap trinh",
            "Internet",
            "Internet",
            2000,
            1,
            1975,
            12000.575f
        );
        Books[1] = new Book(
            "Sach day lap trinh C",
            "Hoc ngon ngu lap trinh C",
            "Ngon ngu lap trinh C",
            "Internet",
            "Internet",
            2000,
            2,
            3216,
            75000.125f
        );
        Books[2] = new Book(
            "Asp.net core mvc to build your website",
            "sach day lap trinh web voi asp.net core mvc",
            "Asp.net core mvc",
            "unknow",
            "Tom and Jone",
            2005,
            3,
            123,
            125000f
        );
        Books[3] = new Book();
        Books[4] = new Book();
    }
    @Override
    public Object[] get() {
        // TODO Auto-generated method stub
        return Books;
    }
}