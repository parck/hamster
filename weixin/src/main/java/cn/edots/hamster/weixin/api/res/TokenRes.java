package cn.edots.hamster.weixin.api.res;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 参数	        说明
 * access_token	获取到的凭证
 * expires_in	凭证有效时间，单位：秒
 */
public class TokenRes extends Result {

    private String token;
    private Long expires;


    @JsonProperty("access_token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("expires_in")
    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

}
