package cn.edots.hamster.weixin.api.cgi_bin.res;

import cn.edots.hamster.weixin.api.res.Result;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * subscribe	用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
 * openId	用户的标识，对当前公众号唯一
 * nickname	用户的昵称
 * sex	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
 * city	用户所在城市
 * country	用户所在国家
 * province	用户所在省份
 * language	用户的语言，简体中文为zh_CN
 * avatar	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
 * dateSubscribe	用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
 * unionId	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
 * remark	公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
 * groupId	用户所在的分组ID（兼容旧的用户分组接口）
 * tagIds	用户被打上的标签ID列表
 * subscribeScene	返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
 * qrScene	二维码扫码场景（开发者自定义）
 * qrSceneMessage	二维码扫码场景描述（开发者自定义）
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoRes extends Result {

    private static final long serialVersionUID = 3213203822884585459L;

    private int subscribe;
    private Long dateSubscribe;
    private String openId;
    private String nickname;
    private int sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatar;
    private String unionId;
    private String remark;
    private int groupId;
    private int[] tagIds;
    private int qrScene;
    private String subscribeScene;
    private String qrSceneMessage;

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    @JsonProperty("openid")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("headimgurl")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @JsonProperty("subscribe_time")
    public Long getDateSubscribe() {
        return dateSubscribe;
    }

    public void setDateSubscribe(Long dateSubscribe) {
        this.dateSubscribe = dateSubscribe;
    }

    @JsonProperty("unionid")
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @JsonProperty("groupid")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("tagid_list")
    public int[] getTagIds() {
        return tagIds;
    }

    public void setTagIds(int[] tagIds) {
        this.tagIds = tagIds;
    }

    @JsonProperty("qr_scene")
    public int getQrScene() {
        return qrScene;
    }

    public void setQrScene(int qrScene) {
        this.qrScene = qrScene;
    }

    @JsonProperty("subscribe_scene")
    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    @JsonProperty("qr_scene_str")
    public String getQrSceneMessage() {
        return qrSceneMessage;
    }

    public void setQrSceneMessage(String qrSceneMessage) {
        this.qrSceneMessage = qrSceneMessage;
    }
}
