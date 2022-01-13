package model;

public enum ChuyenNghanh {
    VH_NT(1), DTVT(2), CNTT(3), CHON_CHUYEN_NGHANH(4);

    private final Integer code;

    ChuyenNghanh(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}