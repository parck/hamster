package cn.edots.hamster.core;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HamsterInitializationFactory {

    private final Retrofit retrofit;
    private final Map<String, Object> apis;
    private int READ_TIME_OUT = 15;
    private int WRITE_TIME_OUT = 15;
    private int CONN_TIME_OUT = 15;

    public HamsterInitializationFactory() {
        this.apis = new HashMap<String, Object>();
        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder()
                .connectTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(CONN_TIME_OUT, TimeUnit.SECONDS);
        this.retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clientBuilder.build())
                .build();
    }

    public HamsterInitializationFactory(Interceptor... interceptors) {
        this.apis = new HashMap<String, Object>();
        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder()
                .connectTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(CONN_TIME_OUT, TimeUnit.SECONDS);
        if (interceptors != null)
            for (Interceptor interceptor : interceptors) clientBuilder.addInterceptor(interceptor);
        this.retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clientBuilder.build())
                .build();
    }

    public HamsterInitializationFactory(OkHttpClient client) {
        this.apis = new HashMap<String, Object>();
        this.retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public HamsterInitializationFactory(OkHttpClient client, retrofit2.CallAdapter.Factory factory) {
        this.apis = new HashMap<String, Object>();
        this.retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(factory)
                .build();
    }

    public <T extends Object> T obtain(Class<T> clazz) {
        if (apis == null || retrofit == null)
            throw new NullPointerException("HamsterInitializationFactory is not Initialization!");
        if (apis.get(clazz.getSimpleName()) != null) return (T) apis.get(clazz.getSimpleName());
        apis.put(clazz.getSimpleName(), this.retrofit.create(clazz));
        return (T) apis.get(clazz.getSimpleName());
    }

    public int getREAD_TIME_OUT() {
        return READ_TIME_OUT;
    }

    public void setREAD_TIME_OUT(int READ_TIME_OUT) {
        this.READ_TIME_OUT = READ_TIME_OUT;
    }

    public int getWRITE_TIME_OUT() {
        return WRITE_TIME_OUT;
    }

    public void setWRITE_TIME_OUT(int WRITE_TIME_OUT) {
        this.WRITE_TIME_OUT = WRITE_TIME_OUT;
    }

    public int getCONN_TIME_OUT() {
        return CONN_TIME_OUT;
    }

    public void setCONN_TIME_OUT(int CONN_TIME_OUT) {
        this.CONN_TIME_OUT = CONN_TIME_OUT;
    }
}
