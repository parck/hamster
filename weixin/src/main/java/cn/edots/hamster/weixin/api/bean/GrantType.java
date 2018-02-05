package cn.edots.hamster.weixin.api.bean;

public enum GrantType {

    CLIENT_CREDENTIAL("client_credential");

    String value;

    GrantType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
