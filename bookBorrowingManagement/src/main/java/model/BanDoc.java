package model;

import java.util.Scanner;

public class BanDoc {
    private static String maBDStactic = "00000";
    private String maBanDoc;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private LoaiBanDoc loaiBanDoc;

    public BanDoc(String hoTen, String diaChi, String sdt, LoaiBanDoc loaiBanDoc) {

        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.loaiBanDoc = loaiBanDoc;
        this.maBanDoc = maBDStactic;
    }

    public BanDoc() {

        this.maBanDoc = maBDStactic;
    }

    public void setMaBanDoc(String maBanDoc) {
        this.maBanDoc = maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LoaiBanDoc getLoaiBanDoc() {
        return loaiBanDoc;
    }

    public void setLoaiBanDoc(LoaiBanDoc loaiBanDoc) {
        this.loaiBanDoc = loaiBanDoc;
    }

    public  String themMaBanDoc() {
        int newMaBanDoc = Integer.parseInt(maBDStactic);
        newMaBanDoc++;
        maBDStactic = Convert.convertIntToStringFiveNumber(newMaBanDoc);

        return maBDStactic;
    }

    public void themBanDoc() {
        this.maBanDoc = themMaBanDoc();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Nhập họ tên: ");
        this.hoTen = scanner.nextLine();
        System.out.print("\n Nhập Địa chỉ: ");
        this.diaChi = scanner.nextLine();
        System.out.print("\n Nhập số điện thoại: ");
        this.sdt = scanner.nextLine();

        System.out.print("\n Nhập loại bạn đọc: ");
        System.out.print("\n 1: là sinh viên ");
        System.out.print("\n 2: là học viên cao học ");
        System.out.print("\n 3: là giáo viên ");

        int inputLoaiBd = scanner.nextInt();

        do {
            switch (inputLoaiBd) {
                case 1:
                    loaiBanDoc = LoaiBanDoc.SINH_VIEN;
                    break;
                case 2:
                    loaiBanDoc = LoaiBanDoc.HOC_VIEN_CAO_HOC;
                    break;
                case 3:
                    loaiBanDoc = LoaiBanDoc.GIAO_VIEN;
                    break;
                default: {
                    loaiBanDoc = LoaiBanDoc.CHON_LOAI_BAN_DOC;
                    System.out.print("\n Nhập loại bạn đọc: ");
                    System.out.print("\n    1: là sinh viên ");
                    System.out.print("\n    2: là học viên cao học ");
                    System.out.print("\n    3: là giáo viên  \n");
                    scanner.nextLine();
                    inputLoaiBd = scanner.nextInt();
                }
            }
        } while (inputLoaiBd < 0 || inputLoaiBd > 3 || Convert.isNumeric(String.valueOf(inputLoaiBd)) == false);

    }

    public String getMaBanDoc() {
        return maBanDoc;
    }



    public void inBanDoc() {
        System.out.println("------------------------------------------");
        System.out.println(getMaBanDoc() + " | " + this.hoTen + " | " + this.diaChi + " | " + this.sdt + " | " + this.loaiBanDoc);
    }
}
