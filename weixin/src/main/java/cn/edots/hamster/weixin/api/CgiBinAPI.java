package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.res.TokenRes;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@API
public interface CgiBinAPI {

    /**
     * access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
     *
     * @param appId  appId appid	是	第三方用户唯一凭证
     * @param secret secret secret	是	第三方用户唯一凭证密钥，即appsecret
     * @return Call<TokenRes>
     */
    @GET("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential")
    Call<TokenRes> token(@Query("appid") String appId, @Query("secret") String secret);

    @GET("https://mp.weixin.qq.com/cgi-bin/showqrcode")
    Call<ResponseBody> showqrcode(@Query("ticket") String ticket);

}
