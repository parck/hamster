package cn.edots.hamster;

import cn.edots.hamster.annotation.API;
import cn.edots.hamster.annotation.APIResource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class RetrofitAutowiredProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Autowired
    private HamsterInitializationFactory hamsterInitializationFactory;

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {

        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {

            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                APIResource apiResource = field.getAnnotation(APIResource.class);
                Resource resource = field.getAnnotation(Resource.class);
                Autowired autowired = field.getAnnotation(Autowired.class);
                if (apiResource == null) if (resource == null) if (autowired == null) return;
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