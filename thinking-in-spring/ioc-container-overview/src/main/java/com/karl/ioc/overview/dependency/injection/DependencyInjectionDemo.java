package com.karl.ioc.overview.dependency.injection;

import com.karl.ioc.overview.dependency.annotion.Super;
import com.karl.ioc.overview.dependency.domain.User;
import com.karl.ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 描述:  依赖注入的Demo
 *
 * @author mh
 * @create 2020-03-31 19:26
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {

        //自动/手动注入
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lnjection-context.xml");
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(userRepository.getUserCollection());
        System.out.println(userRepository.getBeanFactory() == beanFactory);


        //依赖查找  这里会报错
//        System.out.println(beanFactory.getBean(BeanFactory.class));
        ObjectFactory<User> objectFactory = userRepository.getObjectFactory();
        User object = objectFactory.getObject();
        System.out.println(object);


    }
}