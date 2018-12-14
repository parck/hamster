package cn.edots.hamster.weixin.api.cgi_bin;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.param.GetWXACodeParam;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

@API
public interface WxaAppAPI {

    /**
     * 获取小程序二维码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制，详见获取二维码。
     *
     * @param token access_token	string		是	接口调用凭证
     * @param param path	string		是	扫码进入的小程序页面路径，最大长度 128 字节，不能为空
     *              width	number	430	否	二维码的宽度，单位 px。最小 280px，最大 1280px
     * @return errcode    number	错误码
     * errmsg	string	错误信息
     * <p>
     * 如果调用成功，会直接返回图片二进制内容，如果请求失败，会返回 JSON 格式的数据。
     */
    @POST("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode")
    Call createWxaQRCode(@Query("access_token") String token, GetWXACodeParam param);

}
