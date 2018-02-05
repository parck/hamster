package cn.edots.hamster.weixin.api.param;

import cn.edots.hamster.weixin.api.bean.Button;
import cn.edots.hamster.weixin.api.bean.MatchRule;

import java.io.Serializable;
import java.util.List;

public class AddConditionalParameter implements Serializable {

    private static final long serialVersionUID = -8954315313104049757L;

    private List<Button> button;
    private MatchRule matchrule;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    public MatchRule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(MatchRule matchrule) {
        this.matchrule = matchrule;
    }
}
