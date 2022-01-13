package model;

public enum  LoaiBanDoc {
    SINH_VIEN(1), HOC_VIEN_CAO_HOC(2), GIAO_VIEN(3), CHON_LOAI_BAN_DOC(4);
    private final Integer code;

    LoaiBanDoc(Integer  code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}