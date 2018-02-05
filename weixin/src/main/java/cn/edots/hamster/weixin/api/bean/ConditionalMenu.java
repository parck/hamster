package cn.edots.hamster.weixin.api.bean;

import java.io.Serializable;
import java.util.List;

public class ConditionalMenu implements Serializable {

        private static final long serialVersionUID = -3050630723175956647L;

        private List<Button> button;
        private MatchRule matchrule;
        private int menuid;

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

        public int getMenuid() {
            return menuid;
        }

        public void setMenuid(int menuid) {
            this.menuid = menuid;
        }
    }