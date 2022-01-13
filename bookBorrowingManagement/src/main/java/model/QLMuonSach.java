package model;

public class QLMuonSach {
    public static int soDauSach;
    private BanDoc bandoc;
    private Sach[] dsSach = new Sach[soDauSach];
    private int[] soLuong;

    public void muonSach(BanDoc bandoc, Sach[] dsSach, int[] sl){
        this.bandoc = bandoc;
        this.dsSach = dsSach;
        this.soLuong = sl;
    }

    public QLMuonSach(BanDoc bandoc, Sach[] dsSach, int[] dsSoluong) {
        this.bandoc = bandoc;
        this.dsSach = dsSach;
        this.soLuong = dsSoluong;
    }

    public QLMuonSach() {
    }

    public BanDoc getBandoc() {
        return bandoc;
    }

    public void setBandoc(BanDoc bandoc) {
        this.bandoc = bandoc;
    }

    public Sach[] getDsSach() {
        return dsSach;
    }

    public void setSach(Sach[] dsSach) {
        this.dsSach = dsSach;
    }

    public int[] getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int[] soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongSoSachMuon(){
        int sum =0;
        for( int i =0; i< soLuong.length; i++){
            sum = sum + soLuong[i];
        }
        return sum;
    }

    public void inMuonSach() {
        System.out.println("------------------------------------------");
        for (int i = 0; i < soDauSach; i++) {
            System.out.println(bandoc.getMaBanDoc() + " | " + dsSach[i].getMaSach() + " | " + soLuong[i]);
        }
    }
}