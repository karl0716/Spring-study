package com.karl.bean.definition;

import com.karl.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:  Bean alias demo
 *
 * @author mh
 * @create 2020-04-04 16:27
 */
public class BeanAliasDemo {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definition-context.xml");
        // 通过别名进行获取
        User user2 = (User) beanFactory.getBean("user2");
        // 通过Bean name 进行获取
        User user = (User) beanFactory.getBean("user");
        System.out.println(user2 == user);


    }
}