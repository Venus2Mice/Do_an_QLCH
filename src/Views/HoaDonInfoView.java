package Views;

import Models.HoaDon;

public class HoaDonInfoView {
    private HoaDon Model;

    public HoaDonInfoView(HoaDon model) {
        Model = model;
    }

    public void Render() {
        if (Model != null) {
            System.out.println(">>>> HOA DON DETAIL INFORMATION :");
            System.out.println("Ma hoa don : "+Model.getMaHoaDon());
            System.out.println("Ma khach hang : "+Model.getMaKhachHang());
            System.out.println("Tong tien : "+Model.getThanhTien());
            System.out.println("Thoi gian : "+Model.getNgayMua());
            System.out.println("Danh sach san pham : ");
            new BookListView(Model.getDssp()).Render();;
        } else {
            System.out.println("Not found!");
        }
    }
}
