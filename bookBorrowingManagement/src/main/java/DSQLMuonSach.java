import model.BanDoc;
import model.QLMuonSach;
import model.Sach;

import java.util.Scanner;

public class DSQLMuonSach {
    public static int soluongBanDoc;
    public static int soluongSach;
    private Sach[] dsSach;
    private BanDoc[] dsBanDoc;
    private QLMuonSach qlMuonSach;
    private QLMuonSach[] dsqlms;

    public DSQLMuonSach() {

    }

    public void nhapDanhSachBanDoc() {
        dsBanDoc = new BanDoc[soluongBanDoc];
        for (int i = 0; i < dsBanDoc.length; i++) {
            BanDoc newBanDoc = new BanDoc();
            newBanDoc.themBanDoc();
            this.dsBanDoc[i] = newBanDoc;
        }
    }

    public void inDanhSachBanDoc() {
        for (int i = 0; i < dsBanDoc.length; i++) {
            dsBanDoc[i].inBanDoc();
        }
    }

    public void nhapDanhSachSach() {
        dsSach = new Sach[soluongSach];
        for (int i = 0; i < dsSach.length; i++) {
            Sach newSach = new Sach();
            newSach.themSach();
            this.dsSach[i] = newSach;
        }
    }

    public void inDanhSachSach() {
        for (int i = 0; i < dsSach.length; i++) {
            dsSach[i].inSach();
        }
    }

    public void thucHienMuonSach() {
        Scanner scanner = new Scanner(System.in);
        dsqlms = new QLMuonSach[soluongBanDoc];

        // Thực hiện mượn sách cho từng bạn đọc
        for (int j = 0; j < dsqlms.length; j++) {
            String maSachTG = "";

            System.out.println("Thực hiện mượn cho bạn đọc: " + dsBanDoc[j].getHoTen());
            System.out.println("Nhập số lượng đầu sách cần mượn:  ");
            System.out.println(" Bạn chỉ được mượn tối đa 5 đầu sách và ít hơn số sách trong danh sách");
            int soDauSachCanMuon = scanner.nextInt();
            //2. check số lượng đầu sách <= 5
            while (soDauSachCanMuon < 1 || soDauSachCanMuon > 5 || soDauSachCanMuon > dsSach.length) {
                System.out.println("Nhập số lượng đầu sách cần mượn:  ");
                System.out.println(" Bạn chỉ được mượn tối đa 5 đầu sách và ít hơn số sách trong danh sách");
                soDauSachCanMuon = scanner.nextInt();
            }

            QLMuonSach.soDauSach = soDauSachCanMuon;

            Sach[] dsSachMuon = new Sach[QLMuonSach.soDauSach];
            int[] danhSachSL = new int[QLMuonSach.soDauSach];

            for (int i = 0; i < QLMuonSach.soDauSach; i++) {

                System.out.println("Nhập mã sách");
                String maSach = scanner.nextLine();
                System.out.println("check ma sach " + checkMaSach(maSach));

                // check mã sách
                while (!checkMaSach(maSach)) {
                    System.out.println("Nhập mã sách");
                    maSach = scanner.nextLine();
                    System.out.println("check ma sach " + checkMaSach(maSach));
                }

                while (maSachTG.equals(maSach)) {
                    System.out.println("Nhập mã sách");
                    maSach = scanner.nextLine();
                    System.out.println("check ma sach " + checkMaSach(maSach));
                }

                Sach sach = timSachTheoMaSach(maSach, dsSach);
                dsSachMuon[i] = sach;
                System.out.println("Nhập số lượng sách cần mượn:  ");
                System.out.println("Số lượng mượn sách tối đa là 3 quyển:  ");
                int soluong = scanner.nextInt();

                while (soluong < 1 || soluong > 3) {
                    System.out.println("Nhập số lượng sách cần mượn:  ");
                    System.out.println("Số lượng mượn sách tối đa là 3 quyển:  ");
                    soluong = scanner.nextInt();
                }
                danhSachSL[i] = soluong;
                maSachTG = maSach;
            }

            qlMuonSach = new QLMuonSach(dsBanDoc[j], dsSachMuon, danhSachSL);
            dsqlms[j] = qlMuonSach;

        }

    }


    public void inDanhSachMuonSach() {
        for (int i = 0; i < dsqlms.length; i++) {
            dsqlms[i].inMuonSach();
        }
    }

    public void sapXepDSQLMuonSachTheoTenBanDoc() {
//        QLMuonSach[] tempQLMuonSach = new QLMuonSach[soluongBanDoc];
        for (int i = 0; i < dsqlms.length; i++) {
            for (int j = i + 1; j < dsqlms.length; j++) {
                if (dsqlms[i].getBandoc().getHoTen().compareTo(dsqlms[j].getBandoc().getHoTen()) > 0) {
                    QLMuonSach temp = dsqlms[i];
                    dsqlms[i] = dsqlms[j];
                    dsqlms[j] = temp;
                }
            }
        }
    }

    public   void sapXepDSQLMuonSachTheoSoLuongGiamDan() {
        if (dsqlms == null || dsqlms.length == 0) {
            System.out.println("Bạn cần nhập danh sách cho mượn trước khi sắp xếp!");
            return;
        }

        for (int i = 0; i < dsqlms.length; i++) {
            for (int j = i + 1; j < dsqlms.length; j++) {
                if (dsqlms[i].getTongSoSachMuon() < dsqlms[i].getTongSoSachMuon()) {
                    QLMuonSach temp = dsqlms[i];
                    dsqlms[i] = dsqlms[j];
                    dsqlms[j] = temp;
                }
            }
        }
    }

    public  void timKiemDanhSachMuonTheoTenBanDoc() {
        if (dsqlms == null || dsqlms.length == 0) {
            System.out.println("Bạn cần nhập danh sách bạn đọc và đầu sách trước khi cho mượn!");
            return;
        }

        System.out.print("Nhập tên bạn đọc muốn tìm kiếm: ");
        String tenTG = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (int i = 0; i< dsqlms.length; i++) {
            if (dsqlms[i].getBandoc().getHoTen().equals(tenTG)) {
                dsqlms[i].inMuonSach();
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy bạn đọc có tên '" + tenTG + "' trong danh sách mượn sách");
        }
    }


    public BanDoc timBanDocTheoMaBanDoc(String maBanDoc, BanDoc[] dsBanDoc) {
        BanDoc banDoc = new model.BanDoc();
        for (int i = 0; i < dsBanDoc.length; i++) {
            if (dsBanDoc[i].getMaBanDoc().equals(maBanDoc)) {
                banDoc = dsBanDoc[i];
            }
        }
        return banDoc;
    }

    public Sach timSachTheoMaSach(String maSach, Sach[] dsSach) {
        Sach sach = new Sach();

        for (int i = 0; i < dsSach.length; i++) {
            if (dsSach[i].getMaSach().equals(maSach)) {
                sach = dsSach[i];
            }
        }
        return sach;
    }

    public boolean checkMaBanDoc(String maBanDoc) {
        Boolean check = false;
        for (int i = 0; i < dsBanDoc.length; i++) {
            if (dsBanDoc[i].getMaBanDoc().equals(maBanDoc)) {
                check = true;
            }
        }
        return check;
    }

    public boolean checkMaSach(String maSach) {
        Boolean check = false;
        for (int i = 0; i < dsSach.length; i++) {
            if (dsSach[i].getMaSach().equals(maSach)) {
                check = true;
            }
        }
        return check;
    }
}
