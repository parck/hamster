package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.result.AccessResult;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@API
public interface TokenAPI {

    /**
     * @param appId  appId
     * @param secret secret
     * @return AccessResult
     */
    @GET("/cgi-bin/token?grant_type=client_credential")
    void access(@Query("appid") String appId, @Query("secret") String secret, Observer<AccessResult> observer);

    @GET("/cgi-bin/token?grant_type=client_credential")
    Call<AccessResult> access(@Query("appid") String appId, @Query("secret") String secret);

}
