import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        DSQLMuonSach newDSQLMuonSach = new DSQLMuonSach();
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    // Nhập số lượng bạn đọc:
                    System.out.println("Nhập số lượng bạn đọc: ");
                    DSQLMuonSach.soluongBanDoc = scanner.nextInt();
                    newDSQLMuonSach.nhapDanhSachBanDoc();
                    newDSQLMuonSach.inDanhSachBanDoc();
                    break;
                case 2:
                    System.out.println("Nhập số lượng sách: ");
                    DSQLMuonSach.soluongSach = scanner.nextInt();
                    newDSQLMuonSach.nhapDanhSachSach();
                    newDSQLMuonSach.inDanhSachSach();
                    break;
                case 3:
                    newDSQLMuonSach.thucHienMuonSach();
                    System.out.println("Danh sách mượn sách vừa nhập: ");
                    newDSQLMuonSach.inDanhSachMuonSach();
                    break;
                case 4:
                    newDSQLMuonSach.sapXepDSQLMuonSachTheoTenBanDoc();
                    System.out.println("Danh sách sau khi sắp xếp theo tên tăng dần");
                    newDSQLMuonSach.inDanhSachMuonSach();
                    break;
                case 5:
                    System.out.println("Danh sách sau khi sắp xếp theo sơ lượng mượn giảm dần");
                    newDSQLMuonSach.sapXepDSQLMuonSachTheoSoLuongGiamDan();
                    newDSQLMuonSach.inDanhSachMuonSach();
                    break;
                case 6:
                    System.out.println(" Tìm danh sách mươn theo tên");
                    newDSQLMuonSach.timKiemDanhSachMuonTheoTenBanDoc();
                    break;
                case 7:
                    System.exit(0);
            }

        } while (true);
    }

    private static int functionChoice() {
        System.out.println("--------Quản lý mượn sách thư viện--------");
        System.out.println("1.Nhập danh sách bạn đọc");
        System.out.println("2.Nhập danh sách đầu sách mới");
        System.out.println("3.Quản lý mượn sách cho từng bạn đọc");
        System.out.println("4.Sắp xếp danh sách quản lý mượn sách theo tên bạn đọc");
        System.out.println("5.Sắp xếp danh sách quản lý mượn sách theo số lượng mượn giảm dần");
        System.out.println("6.Tìm kiếm và hiển thị danh sách theo tên bạn đọc");
        System.out.println("7.Thoát");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 7) {
                break;
            }
            System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }
}
