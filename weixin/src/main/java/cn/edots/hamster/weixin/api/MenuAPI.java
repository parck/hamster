package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.param.CreateMenuParameter;
import cn.edots.hamster.weixin.api.result.GetMenuResult;
import cn.edots.hamster.weixin.api.result.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@API
public interface MenuAPI {

    /**
     * 创建自定义菜单
     *
     * @param accessToken
     * @param parameter
     * @return
     */
    @POST("https://api.weixin.qq.com/cgi-bin/menu/create")
    Call<Result> create(@Query("access_token") String accessToken, @Body CreateMenuParameter parameter);

    /**
     * 获取菜单信息
     *
     * @param accessToken
     * @return
     */
    @POST("https://api.weixin.qq.com/cgi-bin/menu/get")
    Call<GetMenuResult> get(@Query("access_token") String accessToken);

    /**
     * 删除全部菜单
     *
     * @param accessToken
     * @return
     */
    @POST("https://api.weixin.qq.com/cgi-bin/menu/delete")
    Call<Result> delete(@Query("access_token") String accessToken);

    /**
     * 创建个性化菜单
     *
     * @param accessToken
     * @return
     */
    @POST("https://api.weixin.qq.com/cgi-bin/menu/addconditional")
    Call<Result> addConditional(@Query("access_token") String accessToken);
}
