package cn.edots.hamster.weixin.api.cgi_bin.param;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * expire_seconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
 * action_name	二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
 * action_info	二维码详细信息
 * scene_id	场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
 * scene_str	场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
 */
public class CreateParam {

    private int expire;
    private String name;
    private String info;
    private int sceneId;
    private String sceneMessage;

    @JsonProperty("expire_seconds")
    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    @JsonProperty("action_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("action_info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @JsonProperty("scene_id")
    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    @JsonProperty("scene_str")
    public String getSceneMessage() {
        return sceneMessage;
    }

    public void setSceneMessage(String sceneMessage) {
        this.sceneMessage = sceneMessage;
    }
}
