package cn.edots.hamster.weixin.model;

import cn.edots.ormosia.model.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "wx_application_tbl", uniqueConstraints = {
        @UniqueConstraint(columnNames = "app_id")
})
public class WXApplication extends Domain {

    private static final long serialVersionUID = 2691895603505214968L;

    private String name;
    private String appId;
    private String secret;
    private String token;
    private Date dateExpiration;
    private String encodingAESKey;
    private String url;

    @Column(name = "name", length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "app_id", length = 128, nullable = false)
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Column(name = "secret", nullable = false)
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Column(name = "encoding_aes_key", nullable = false)
    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    @Column(name = "url", nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
