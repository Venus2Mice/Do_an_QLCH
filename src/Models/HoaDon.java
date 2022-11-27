package Models;

import java.time.LocalDate;

public class HoaDon {
    private String MaHoaDon;
    private LocalDate NgayMua;
    private int MaKhachHang;
    private double ThanhTien;
    private Book dssp[];// danh sach san pham

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, LocalDate ngayMua, int maNhanVien, double thanhTien) {
        MaHoaDon = maHoaDon;
        NgayMua = ngayMua;
        MaKhachHang = maNhanVien;
        ThanhTien = thanhTien;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public LocalDate getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(LocalDate ngaymua2) {
        NgayMua = ngaymua2;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double thanhTien) {
        ThanhTien = thanhTien;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        MaKhachHang = maKhachHang;
    }

    public Book[] getDssp() {
        return dssp;
    }

    public void setDssp(Book[] dssp) {
        this.dssp = dssp;
    }

}