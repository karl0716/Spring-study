package com.karl.bean.definition;

import com.karl.ioc.overview.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 描述:  BeanDefinition builder
 *
 * @author mh
 * @create 2020-04-04 12:24
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //01 通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("name", "karl");
        beanDefinitionBuilder.addPropertyValue("age", 19);
        // 获取BeanDefinition
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 这里的BeanDefinition并非是终态
        System.out.println(beanDefinition);


        // 02 AbstractBeanDefinition 构建

        AbstractBeanDefinition abstractBeanDefinition = new GenericBeanDefinition();
        abstractBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues()
                .add("name", "karl")
                .add("age", 19);
        abstractBeanDefinition.setPropertyValues(mutablePropertyValues);


    }

}