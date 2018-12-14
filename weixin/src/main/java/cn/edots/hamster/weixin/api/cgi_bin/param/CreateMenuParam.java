package cn.edots.hamster.weixin.api.cgi_bin.param;

import cn.edots.hamster.weixin.api.bean.Button;

import java.io.Serializable;
import java.util.List;

public class CreateMenuParam implements Serializable {

    private static final long serialVersionUID = 6274695458432793648L;

    /**一级菜单数组，个数应为1~3个*/
    private List<Button> button;


    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}
