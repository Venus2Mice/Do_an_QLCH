package Views;

import Models.HoaDon;

public class HoaDonListView {
    private HoaDon []Models;

    public HoaDonListView(HoaDon[] models) {
        Models = models;
    }
    public void Render(){
        if (Models.length == 0) {
            System.out.println("Danh sach rong!!!");
            return;
        }
        System.out.println("\t\t\t\t\t\t\tDanh sach cac cuon sach:");
        for (HoaDon hoaDon : Models) {
            new HoaDonInfoView(hoaDon).Render();
            System.out.println();
        }
    }
}
