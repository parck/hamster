package cn.edots.hamster.weixin.api.cgi_bin.res;

import cn.edots.hamster.weixin.api.res.Result;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 参数	说明
 * total	关注该公众账号的总用户数
 * count	拉取的OPENID个数，最大值为10000
 * data	列表数据，OPENID的列表
 * next_openid	拉取列表的最后一个用户的OPENID
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRes extends Result {

    private static final long serialVersionUID = 5230589321873781881L;

    private int total;
    private int count;
    private Data data;
    private String nextId;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("next_openid")
    public String getNextId() {
        return nextId;
    }

    public void setNextId(String nextId) {
        this.nextId = nextId;
    }

    public static class Data {

        private String[] openIds;

        @JsonProperty("openid")
        public String[] getOpenIds() {
            return openIds;
        }

        public void setOpenIds(String[] openIds) {
            this.openIds = openIds;
        }

    }
}
