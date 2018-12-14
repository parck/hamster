package cn.edots.hamster.weixin.api.cgi_bin.res;

import cn.edots.hamster.weixin.api.res.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ticket	获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
 * expire_seconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
 * url	二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
 */
public class CreateRes extends Result {

    private static final long serialVersionUID = -3528699994259511742L;

    private String ticket;
    private String expire;
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @JsonProperty("expire_seconds")
    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
