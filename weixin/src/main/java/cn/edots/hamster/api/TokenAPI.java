package cn.edots.hamster.api;

import cn.edots.hamster.annotation.API;
import cn.edots.hamster.api.result.AccessResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@API
public interface TokenAPI {

    @GET("/cgi-bin/token")
    Observable<AccessResult> access(@Query("appid") String appId, @Query("grant_type") String grantType, @Query("secret") String secret);
}
