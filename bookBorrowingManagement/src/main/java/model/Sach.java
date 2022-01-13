package model;

import java.util.Scanner;

public class Sach {
    private static String maSachStatic = "00000";
    private  String maSach;
    private  String tenSach;
    private  String tacGia;
    private ChuyenNghanh chuyenNghanh;
    private  int namXuatBan;

    public Sach(String tenSach, String tacGia, ChuyenNghanh chuyenNghanh, int namXuatBan) {

        this.maSach = maSachStatic;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNghanh = chuyenNghanh;
        this.namXuatBan = namXuatBan;
    }
    public Sach() {

        this.maSach = maSachStatic;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public ChuyenNghanh getChuyenNghanh() {
        return chuyenNghanh;
    }

    public void setChuyenNghanh(ChuyenNghanh chuyenNghanh) {
        this.chuyenNghanh = chuyenNghanh;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    private static String themMaSach() {
        int newMaSach = Integer.parseInt(maSachStatic);
        newMaSach++;
        maSachStatic = Convert.convertIntToStringFiveNumber(newMaSach);
        return maSachStatic;
    }

    public void themSach() {
        this.maSach = themMaSach();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n Nhập tên sách: ");
        this.tenSach = scanner.nextLine();
        System.out.print("\n Nhập tác giả: ");
        this.tacGia = scanner.nextLine();
        System.out.print("\n Nhập chuyên nghành: ");
        System.out.print("\n    1: là VN-NT ");
        System.out.print("\n    2: là DTVT ");
        System.out.print("\n    3: là CNTT \n");

        int inputChuyenNghanh = scanner.nextInt();

        do {
            switch (inputChuyenNghanh) {
                case 1:
                    chuyenNghanh = ChuyenNghanh.VH_NT;
                    break;
                case 2:
                    chuyenNghanh = ChuyenNghanh.DTVT;
                    break;
                case 3:
                    chuyenNghanh = ChuyenNghanh.CNTT;
                    break;
                default: {
                    chuyenNghanh = ChuyenNghanh.CHON_CHUYEN_NGHANH;
                    System.out.print("\n Nhập chuyên nghành: ");
                    System.out.print("\n 1: là VN-NT ");
                    System.out.print("\n 2: là DTVT ");
                    System.out.print("\n 3: là CNTT ");
                    scanner.nextLine();
                    inputChuyenNghanh = scanner.nextInt();
                }
            }
        } while (inputChuyenNghanh < 0 || inputChuyenNghanh > 3 || Convert.isNumeric(String.valueOf(inputChuyenNghanh)) == false);

        System.out.print("\n Nhập năm xuất bản: ");
        this.namXuatBan = scanner.nextInt();

    }

    public String getMaSach() {
        return maSach;
    }

    public void inSach() {
        System.out.println("------------------------------------------");
        System.out.println(getMaSach() + " | " + this.tenSach + " | " + this.tacGia + " | " + this.chuyenNghanh + " | " + this.namXuatBan);
    }
}