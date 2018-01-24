package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.result.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@API
public interface WebAPI {

    @GET("/connect/oauth2/authorize?response_type=code&state={state}#wechat_redirect")
    Call<Result> authorize(@Query("appid") String appId, @Query("redirect_uri") String redirectURI, @Query("scope") String scope, @Path("state") String state);
}
