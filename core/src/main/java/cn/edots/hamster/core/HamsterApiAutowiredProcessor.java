package cn.edots.hamster.core;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.core.annotation.Inject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;

public class HamsterApiAutowiredProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private final HamsterApiProvider hamsterApiProvider;

    public HamsterApiAutowiredProcessor() {
        this.hamsterApiProvider = new HamsterApiProvider();
    }

    public HamsterApiAutowiredProcessor(HamsterApiProvider hamsterApiProvider) {
        this.hamsterApiProvider = hamsterApiProvider;
    }

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {

            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                Inject inject = field.getAnnotation(Inject.class);
                if (inject == null) {
                    Resource resource = field.getAnnotation(Resource.class);
                    if (resource == null) {
                        Autowired autowired = field.getAnnotation(Autowired.class);
                        if (autowired == null) return;
                    }
                }
                //读取注解中的值
                API api = field.getType().getAnnotation(API.class);
                if (api == null) return;
                //根据地址创建retrofit
                Object object = hamsterApiProvider.obtain(field.getType());
                if (object == null) return;
                field.setAccessible(true);
                field.set(bean, object);
            }
        });

        return super.postProcessAfterInstantiation(bean, beanName);
    }
}