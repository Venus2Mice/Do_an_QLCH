package Controller;

import java.time.LocalDate;

import Models.Book;
import Models.HoaDon;
import Repository.HoaDonRepo;
import Repository.IDataAccess;
import Views.HoaDonInfoView;
import Views.HoaDonListView;

public class HoaDonController {
    private HoaDonRepo list;

    public HoaDonController(IDataAccess data) {
        list = new HoaDonRepo(data);
    }
    public void List() {
        var models = list.Select();
        new HoaDonListView(models).Render();;
    }
    public void Insert(int makhachhang, String mahoadon, LocalDate ngaymua, double thanhtien, Book []ds) {
        var model = new HoaDon();
        model.setMaKhachHang(makhachhang);
        model.setDssp(ds);
        model.setNgayMua(ngaymua);
        model.setThanhTien(thanhtien);
        model.setMaHoaDon(mahoadon);
        list.insert(model);
    }
    public void Search(int id){
        var model = list.Select(id);
        new HoaDonInfoView(model).Render();;
    }
}   
