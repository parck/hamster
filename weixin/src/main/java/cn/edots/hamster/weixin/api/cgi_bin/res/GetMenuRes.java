package cn.edots.hamster.weixin.api.cgi_bin.res;

import cn.edots.hamster.weixin.api.bean.ConditionalMenu;
import cn.edots.hamster.weixin.api.bean.Menu;
import cn.edots.hamster.weixin.api.res.Result;

public class GetMenuRes extends Result {

    private static final long serialVersionUID = 2425246986360712083L;

    private Menu menu;
    private ConditionalMenu conditionalmenu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ConditionalMenu getConditionalmenu() {
        return conditionalmenu;
    }

    public void setConditionalmenu(ConditionalMenu conditionalmenu) {
        this.conditionalmenu = conditionalmenu;
    }

}
