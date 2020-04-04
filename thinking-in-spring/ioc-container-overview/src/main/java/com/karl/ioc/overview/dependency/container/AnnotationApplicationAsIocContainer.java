package com.karl.ioc.overview.dependency.container;

import com.karl.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 描述:  ApplicationContext as Ioc container
 *
 * @author mh
 * @create 2020-04-01 21:12
 */
public class AnnotationApplicationAsIocContainer {

    public static void main(String[] args) {
        //创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationAsIocContainer 作为配置类 configuration class
        applicationContext.register(AnnotationApplicationAsIocContainer.class);
        //启动上下文
        applicationContext.refresh();
        lookupCollectionType(applicationContext);


        // 停止容器
        applicationContext.close();

    }








    @Bean
    public User user(){
        User user = new User();
        user.setAge(9);
        user.setName("karl");
        return user;
    }


    private static void lookupCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("Map的个数为:" + beansOfType.size());
        }

    }

}