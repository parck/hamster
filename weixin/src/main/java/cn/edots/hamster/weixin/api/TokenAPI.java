package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.result.AccessResult;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

@API
public abstract class TokenAPI {

    /**
     * @param appId  appId
     * @param secret secret
     * @return Call<AccessResult>
     */
    @GET("/cgi-bin/token?grant_type=client_credential")
    public abstract Call<AccessResult> access(@Query("appid") String appId, @Query("secret") String secret);

    public void access(String appId, String secret, final Observer<AccessResult> observer) {
        access(appId, secret).enqueue(new Callback<AccessResult>() {
            public void onResponse(Call<AccessResult> call, Response<AccessResult> response) {
                observer.onNext(response.body());
                observer.onComplete();
            }

            public void onFailure(Call<AccessResult> call, Throwable throwable) {
                observer.onError(throwable);
                observer.onComplete();
            }
        });
    }

}
