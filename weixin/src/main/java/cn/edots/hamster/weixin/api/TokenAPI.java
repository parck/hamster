package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.result.AccessResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static cn.edots.hamster.weixin.Constant.host;

@API
public interface TokenAPI {

    /**
     * @param appId  appId
     * @param secret secret
     * @return Call<AccessResult>
     */
    @GET("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential")
    Call<AccessResult> access(@Query("appid") String appId, @Query("secret") String secret);

    /**
     * @param appId  appId
     * @param secret secret
     * @return Call<AccessResult>
     */
    @GET("https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code")
    Call<AccessResult> access(@Query("appid") String appId, @Query("secret") String secret, @Query("code") String code);

}
