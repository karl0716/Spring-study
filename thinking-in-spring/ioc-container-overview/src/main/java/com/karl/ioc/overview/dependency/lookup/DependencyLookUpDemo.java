package com.karl.ioc.overview.dependency.lookup;

import com.karl.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 描述:  依赖查找的Demo
 *
 * @author mh
 * @create 2020-03-31 19:26
 */
public class DependencyLookUpDemo {
    public static void main(String[] args) {


        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        //通过名称进行查找
//
//        // 实时查找
//        lookupRealTime(beanFactory);
//        // 延迟查找
//        lockupInLazy(beanFactory);


        // 通过类型进行查找
        // 单一的Bean
//        lookupByType(beanFactory);
        //集合的Bean
        lookupCollectionType(beanFactory);





    }

    private static void lookupCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("Map的个数为:" + beansOfType.size());
        }

    }

    private static void lockupInLazy(BeanFactory beanFactory) {

        ObjectFactory<User> objectFactoryCreatingFactoryBean = (ObjectFactory<User>) beanFactory.getBean("objectFactoryCreatingFactoryBean");
        User object = objectFactoryCreatingFactoryBean.getObject();
        System.out.println(object);
    }

    private static void lookupRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println("lookUpByType:" + bean);
    }


}