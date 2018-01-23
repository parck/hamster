package cn.edots.hamster;

import cn.edots.hamster.api.API;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private static Retrofit retrofit;
    private static Map<String, API> apis = new HashMap<String, API>();

    public Retrofit initRetrofit() {
        if (retrofit != null) return retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weixin.qq.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
