package cn.edots.hamster.weixin.api.bean;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

        private static final long serialVersionUID = -7439690755776513497L;

        List<Button> bean;

        public List<Button> getBean() {
            return bean;
        }

        public void setBean(List<Button> bean) {
            this.bean = bean;
        }
    }