package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.result.AccessResult;
import cn.edots.hamster.weixin.api.result.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@API
public interface Oauth2API {

    @GET("https://api.weixin.qq.com/connect/oauth2/authorize?response_type=code")
    Call<Result> authorize(@Query("appid") String appId, @Query("redirect_uri") String redirectURI, @Query("scope") String scope, @Query("state") String state);

    /**
     * @param appId  appId
     * @param secret secret
     * @return Call<AccessResult>
     */
    @GET("https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code")
    Call<AccessResult> access(@Query("appid") String appId, @Query("secret") String secret, @Query("code") String code);

}

