package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.result.AccessResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@API
public interface TokenAPI {

    @GET("/cgi-bin/token")
    Observable<AccessResult> access(@Query("appid") String appId, @Query("grant_type") String grantType, @Query("secret") String secret);
}
