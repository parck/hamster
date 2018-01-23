package cn.edots.hamster.weixin;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.core.annotation.Inject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class RetrofitAutowiredProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private final HamsterInitializationFactory hamsterInitializationFactory;

    public RetrofitAutowiredProcessor() {
        this.hamsterInitializationFactory = new HamsterInitializationFactory();
    }

    public RetrofitAutowiredProcessor(HamsterInitializationFactory hamsterInitializationFactory) {
        this.hamsterInitializationFactory = hamsterInitializationFactory;
    }

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {

            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                Inject inject = field.getAnnotation(Inject.class);
                if (inject == null) return;
                //读取注解中的值
                API api = field.getType().getAnnotation(API.class);
                if (api == null) return;
                //根据地址创建retrofit
                Object object = hamsterInitializationFactory.create(field.getType());
                if (object == null) return;
                field.setAccessible(true);
                field.set(bean, object);
            }
        });

        return super.postProcessAfterInstantiation(bean, beanName);
    }
}