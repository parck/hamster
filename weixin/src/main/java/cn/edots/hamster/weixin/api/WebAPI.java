package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.result.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static cn.edots.hamster.weixin.Constant.host;

@API
public interface WebAPI {

    @GET(host + "/connect/oauth2/authorize?response_type=code")
    Call<Result> authorize(@Query("appid") String appId, @Query("redirect_uri") String redirectURI, @Query("scope") String scope, @Query("state") String state);
}

