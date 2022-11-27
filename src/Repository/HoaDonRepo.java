package Repository;

import java.util.Arrays;

import Models.HoaDon;

public class HoaDonRepo {
    public HoaDon list[];

    public HoaDonRepo(IDataAccess data) {
        data.Load();
        list = (HoaDon[]) data.get();
    }

    public void insert(HoaDon newHoaDon) {
        boolean found = false;
        if (Select(newHoaDon.getMaHoaDon()).length > 0) {
            found = true;
        }
        if (!found) {
            list = Arrays.copyOf(list, list.length + 1);
            list[list.length - 1] = newHoaDon;
        }
    }

    // select theo tu khoa tra ve mang cac hoa don chua tu khoa
    public HoaDon[] Select(String key) {
        HoaDon temp[] = new HoaDon[0];
        key = key.toLowerCase();
        for (HoaDon hoaDon : list) {
            var logic = hoaDon.getMaHoaDon().toLowerCase().contains(key);
            if (logic) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = hoaDon;
            }
        }
        return temp;
    }

    public HoaDon[] Select() {
        return list;
    }

    // select theo id
    public HoaDon Select(int id) {
        for (HoaDon hoaDon : list) {
            if (hoaDon.getMaKhachHang() == (id)) {
                return hoaDon;
            }
        }
        return null;
    }
}
