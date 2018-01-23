package cn.edots.hamster.api.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessResult extends Result {

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
