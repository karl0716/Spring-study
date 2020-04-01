package com.karl.ioc.overview.dependency.container;

import com.karl.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * 描述:  使用SpringICO容器是使用ApplicationContext还是使用BeanFactory
 *
 * @author mh
 * @create 2020-04-01 20:43
 */
public class BeanFactoryAsIocContainer {

    public static void main(String[] args) {
        //创建BeanFactory容器
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        // 加载配置
        String location = "META-INF/dependency-lookup-context.xml";
        int beanNum = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        // 打印加载Bean个数
        System.out.println(beanNum);
        lookupCollectionType(defaultListableBeanFactory);
    }

    private static void lookupCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("Map的个数为:" + beansOfType.size());
        }

    }

}