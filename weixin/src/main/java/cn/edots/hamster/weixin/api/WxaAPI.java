package cn.edots.hamster.weixin.api;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.param.GetWXACodeParam;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@API
public interface WxaAPI {

    /**
     * 获取小程序码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制，详见获取二维码。
     *
     * @param token access_token	string		是	接口调用凭证
     * @param param path	string		是	扫码进入的小程序页面路径，最大长度 128 字节，不能为空
     *              width	number	430	否	二维码的宽度，单位 px。最小 280px，最大 1280px
     *              auto_color	boolean	false	否	自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
     *              line_color	Object	{"r":0,"g":0,"b":0}	否	auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     *              is_hyaline	boolean	false	否	是否需要透明底色，为 true 时，生成透明底色的小程序码
     * @return errcode    number	错误码
     * errmsg	string	错误信息
     * 如果调用成功，会直接返回图片二进制内容，如果请求失败，会返回 JSON 格式的数据。
     */
    @POST("https://api.weixin.qq.com/wxa/getwxacode")
    Call<RequestBody> getWXACode(@Query("access_token") String token, @Body GetWXACodeParam param);

    /**
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。 更多用法详见 获取二维码。
     *
     * @param token access_token	string		是	接口调用凭证
     * @param param scene	string		是	最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     *              page	string	主页	否	必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
     *              width	number	430	否	二维码的宽度，单位 px，最小 280px，最大 1280px
     *              auto_color	boolean	false	否	自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false
     *              line_color	Object	{"r":0,"g":0,"b":0}	否	auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     *              is_hyaline	boolean	false	否	是否需要透明底色，为 true 时，生成透明底色的小程序
     * @return errcode    number	错误码
     * errmsg	string	错误信息
     * 如果调用成功，会直接返回图片二进制内容，如果请求失败，会返回 JSON 格式的数据。
     */
    @POST("https://api.weixin.qq.com/wxa/getwxacodeunlimit")
    Call<RequestBody> getWXACodeUnLimit(@Query("access_token") String token, @Body GetWXACodeParam param);

}
