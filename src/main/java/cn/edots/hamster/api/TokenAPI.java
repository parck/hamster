package cn.edots.hamster.api;

import cn.edots.hamster.api.result.AccessResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TokenAPI extends API {

    @GET("/cgi-bin/token")
    Observable<AccessResult> access(@Query("appid") String appId, @Query("grant_type") String grantType, @Query("secret") String secret);
}
