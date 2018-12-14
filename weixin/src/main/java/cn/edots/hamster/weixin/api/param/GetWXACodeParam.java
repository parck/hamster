package cn.edots.hamster.weixin.api.param;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * scene	    string	    	                是	 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
 * page	        string	  主页	                否   必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
 * access_token	string	    	                是	 接口调用凭证
 * path	        string	    	                是	 扫码进入的小程序页面路径，最大长度 128 字节，不能为空
 * width	    number	 430	                否	 二维码的宽度，单位 px。最小 280px，最大 1280px
 * auto_color	boolean	 false	                否	 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
 * line_color	Object	 {"r":0,"g":0,"b":0}	否	 auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
 * is_hyaline	boolean	 false	                否   是否需要透明底色，为 true 时，生成透明底色的小程序码
 */
public class GetWXACodeParam {

    private String scene;
    private String page;
    private String path;
    private int width;
    private boolean autoColor;
    private RGB lineColor;
    private boolean hyaLine;

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @JsonProperty("auto_color")
    public boolean isAutoColor() {
        return autoColor;
    }

    public void setAutoColor(boolean autoColor) {
        this.autoColor = autoColor;
    }

    @JsonProperty("line_color")
    public RGB getLineColor() {
        return lineColor;
    }

    public void setLineColor(RGB lineColor) {
        this.lineColor = lineColor;
    }

    @JsonProperty("is_hyaline")
    public boolean isHyaLine() {
        return hyaLine;
    }

    public void setHyaLine(boolean hyaLine) {
        this.hyaLine = hyaLine;
    }

    //=============================================================================================
    // inner class
    //=============================================================================================
    public static class RGB {
        private int r;
        private int g;
        private int b;

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

}
