package cn.edots.hamster.weixin.api.bean;

public enum ButtonType {
    VIEW("view"), CLICK("click"), MINI_PROGRAM("miniprogram");
    String value;

    ButtonType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}