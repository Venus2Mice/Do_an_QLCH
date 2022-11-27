package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        new HoaDonListView(models).Render();
        ;
    }

    public void Insert(int makhachhang, String mahoadon, LocalDate ngaymua, double thanhtien, Book[] ds) {
        var model = new HoaDon();
        model.setMaKhachHang(makhachhang);
        model.setDssp(ds);
        model.setNgayMua(ngaymua);
        model.setThanhTien(thanhtien);
        model.setMaHoaDon(mahoadon);
        list.insert(model);
    }

    public void Search(int id) {
        var model = list.Select(id);
        new HoaDonInfoView(model).Render();
    }

    public void GhiFile(String path) throws IOException {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            var tmp = list.Select();
            bw.write(tmp.length + "");
            bw.newLine();
            for (HoaDon hoaDon : tmp) {
                bw.write("{");
                bw.newLine();
                bw.write(hoaDon.getMaHoaDon() + "");
                bw.newLine();
                bw.write(hoaDon.getMaKhachHang() + "");
                bw.newLine();
                bw.write(hoaDon.getNgayMua() + "");
                bw.newLine();
                bw.write(hoaDon.getThanhTien() + "");
                bw.newLine();
                var tmp1 = hoaDon.getDssp();
                for (Book book : tmp1) {
                    bw.write("{");
                    bw.newLine();
                    bw.write(book.getAuthors());
                    bw.newLine();
                    bw.write(book.getBookName());
                    bw.newLine();
                    bw.write(book.getDescription());
                    bw.newLine();
                    bw.write(book.getEditon() + "");
                    bw.newLine();
                    bw.write(book.getId() + "");
                    bw.newLine();
                    bw.write(book.getIsbn() + "");
                    bw.newLine();
                    bw.write(book.getPublisher());
                    bw.newLine();
                    bw.write(book.getTitle());
                    bw.newLine();
                    bw.write(book.getYear() + "");
                    bw.newLine();
                    bw.write(book.getPrice() + "");
                    bw.newLine();
                    bw.write("},");
                    bw.newLine();
                }
                bw.newLine();
                bw.write("},");
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
