package cn.edots.hamster.weixin.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Code2sessionRes extends Result {

    private static final long serialVersionUID = 3148448726046429254L;

    private String openId;
    private String sessionKey;
    private String unionId;

    @JsonProperty("openid")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @JsonProperty("session_key")
    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @JsonProperty("unionid")
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}