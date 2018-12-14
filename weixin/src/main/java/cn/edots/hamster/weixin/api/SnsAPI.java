package cn.edots.hamster.weixin.api;

import cn.edots.hamster.weixin.api.res.Code2sessionRes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SnsAPI {

    @GET("https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code")
    Call<Code2sessionRes> code2session(@Query("appid") String appId, @Query("secret") String secret, @Query("js_code") String code);

}