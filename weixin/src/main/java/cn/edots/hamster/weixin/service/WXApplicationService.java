package cn.edots.hamster.weixin.service;

import cn.edots.hamster.weixin.model.WXApplication;
import cn.edots.ormosia.service.DomainService;

import java.io.IOException;

public interface WXApplicationService extends DomainService<Long, WXApplication> {

    String obtainToken(WXApplication application) throws Exception;
}
