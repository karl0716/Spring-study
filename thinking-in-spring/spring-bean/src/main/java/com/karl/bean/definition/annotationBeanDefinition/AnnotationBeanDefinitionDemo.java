package com.karl.bean.definition.annotationBeanDefinition;

import com.karl.ioc.overview.dependency.container.AnnotationApplicationAsIocContainer;
import com.karl.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 描述:  Annotation BeanDefinition demo
 * 注解的形式注册Bean
 *
 * @author mh
 * @create 2020-04-04 19:07
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        //创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将Config 类 作为配置类 configuration class（配置类）
        applicationContext.register(Config.class);


        //启动上下文
        applicationContext.refresh();


        //01 通过@Bean注册BeanDefinition

        //02 通过@Component

        //03 通过import进行导入


        //命名方式
        registerBeanDefinition(applicationContext, "user03", User.class);

        // 非命名
        registerBeanDefinition(applicationContext, User.class);


        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        System.out.println(beansOfType.size());


        //显式关闭
        applicationContext.close();

    }


    /**
     * 通过java Api 命名方式 方式进行注册
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry, String beanName,Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);

        beanDefinitionBuilder.addPropertyValue("name", "karl")
                .addPropertyValue("age", 30);


        if(StringUtils.isEmpty(beanName)){
            // 为空 非命名方式进行注册
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), beanDefinitionRegistry);
        } else {
            // 注册BeanDefinition
            beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        }
    }

    /**
     * 通过java Api 非命名方式 方式进行调用
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry,Class<?> beanClass) {
        registerBeanDefinition(beanDefinitionRegistry, null, beanClass);
    }


    @Component
    public static class Config {
        @Bean(name = {"user01", "user02"})
        public User user() {
            User user = new User();
            user.setAge(9);
            user.setName("karl");
            return user;
        }
    }
}