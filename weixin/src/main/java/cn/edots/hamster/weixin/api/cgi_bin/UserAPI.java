package cn.edots.hamster.weixin.api.cgi_bin;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.cgi_bin.res.GetRes;
import cn.edots.hamster.weixin.api.cgi_bin.res.InfoRes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@API
public interface UserAPI {

    /**
     * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     *
     * @param token  access_token	是	调用接口凭证
     * @param nextId next_openid	是	第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    @GET("https://api.weixin.qq.com/cgi-bin/user/get")
    Call<GetRes> get(@Query("access_token") String token, @Query("next_openid") String nextId);

    /**
     * 开发者可通过OpenID来获取用户基本信息。请使用https协议。
     *
     * @param token  access_token	是	调用接口凭证
     * @param openId openid	是	普通用户的标识，对当前公众号唯一
     * @return
     */
    @GET("https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN")
    Call<InfoRes> info(@Query("access_token") String token, @Query("openid") String openId);

}
