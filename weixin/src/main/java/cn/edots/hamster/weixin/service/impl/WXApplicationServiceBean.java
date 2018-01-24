package cn.edots.hamster.weixin.service.impl;

import cn.edots.hamster.core.annotation.Inject;
import cn.edots.hamster.weixin.api.TokenAPI;
import cn.edots.hamster.weixin.api.result.AccessResult;
import cn.edots.hamster.weixin.dao.WXApplicationDAO;
import cn.edots.hamster.weixin.model.WXApplication;
import cn.edots.hamster.weixin.service.WXApplicationService;
import cn.edots.ormosia.dao.DomainDAO;
import cn.edots.ormosia.service.DomainServiceBean;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Service("wxApplicationServiceBean")
public class WXApplicationServiceBean extends DomainServiceBean<Long, WXApplication> implements WXApplicationService {

    @Resource
    private WXApplicationDAO wxApplicationHDAO;

    @Inject
    private TokenAPI tokenAPI;

    public DomainDAO<Long, WXApplication> getEntityDAO() {
        return wxApplicationHDAO;
    }

    @Override
    public WXApplication get(Criterion... criterias) {
        WXApplication application = super.get(criterias);
        application.setToken(obtainToken(application));
        return application;
    }

    @Override
    public WXApplication get(Long key) {
        WXApplication application = super.get(key);
        application.setToken(obtainToken(application));
        return application;
    }

    @Override
    public WXApplication get(String key) {
        WXApplication application = super.get(key);
        application.setToken(obtainToken(application));
        return application;
    }

    public String obtainToken(WXApplication application) {
        if (application == null) return null;
        if (StringUtils.isEmpty(application.getToken()) || application.getDateExpiration() == null
                || application.getDateExpiration().getTime() < System.currentTimeMillis()) {
            try {
                AccessResult result = tokenAPI
                        .access(application.getAppId(), application.getSecret())
                        .execute()
                        .body();
                application.setToken(result.getToken());
                application.setDateExpiration(new Date(System.currentTimeMillis() + result.getExpires() * 800));
                merge(application);
                return result.getToken();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return application.getToken();
    }
}
