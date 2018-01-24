package cn.edots.hamster.weixin.dao.impl;

import cn.edots.hamster.weixin.dao.WXApplicationDAO;
import cn.edots.hamster.weixin.model.WXApplication;
import cn.edots.ormosia.dao.DomainHDAO;
import org.springframework.stereotype.Repository;

@Repository("wxApplicationHDAO")
public class WXApplicationHDAO extends DomainHDAO<Long, WXApplication> implements WXApplicationDAO {
}
