package Repository;

import Models.HoaDon;

public class HoaDonData implements IDataAccess {
    private HoaDon[] list;

    @Override
    public Object[] get() {

        return list;
    }

    @Override
    public void Load() {
        list = new HoaDon[0];
    }

}
