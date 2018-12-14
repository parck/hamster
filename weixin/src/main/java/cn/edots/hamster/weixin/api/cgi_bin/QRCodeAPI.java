package cn.edots.hamster.weixin.api.cgi_bin;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.weixin.api.cgi_bin.param.CreateParam;
import cn.edots.hamster.weixin.api.cgi_bin.res.CreateRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@API
public interface QRCodeAPI {

    /**
     * 每次创建二维码ticket需要提供一个开发者自行设定的参数（scene_id），分别介绍临时二维码和永久二维码的创建二维码ticket过程。
     *
     * @param token access_token	string		是	接口调用凭证
     * @param param expire_seconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     *              action_name	二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
     *              action_info	二维码详细信息
     *              scene_id	场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     *              scene_str	场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @return
     */
    @POST("https://api.weixin.qq.com/cgi-bin/qrcode/create")
    Call<CreateRes> create(@Query("access_token") String token, @Body CreateParam param);

}
