package Book;

import Help.Help;

public class Novel extends Book {
    private int Sochu;

    @Override
    public void RenderBook() {
        // TODO Auto-generated method stub
        super.RenderBook();
        System.out.println(">Tong so chu : " + getSochu());

    }

    @Override
    public void SetBook() {
        // TODO Auto-generated method stub
        super.SetBook();
        this.setSochu(Help.inputInt(">Tong so chu :"));
    }

    public int getSochu() {
        return Sochu;
    }

    public void setSochu(int sochu) {
        Sochu = sochu;
    }
}
