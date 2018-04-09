package cn.edots.hamster.core;

import cn.edots.hamster.core.annotation.API;
import cn.edots.hamster.core.annotation.Inject;
import cn.edots.hamster.core.annotation.HOST;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;
import retrofit2.http.GET;
import retrofit2.http.POST;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

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
                Object object = hamsterInitializationFactory.obtain(field.getType());
                if (object == null) return;
                field.setAccessible(true);
                field.set(bean, object);
            }
        });

        return super.postProcessAfterInstantiation(bean, beanName);
    }
}