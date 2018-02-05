package cn.edots.hamster.weixin.api.result;

import cn.edots.hamster.weixin.api.bean.ConditionalMenu;
import cn.edots.hamster.weixin.api.bean.Menu;

public class GetMenuResult extends Result {

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
