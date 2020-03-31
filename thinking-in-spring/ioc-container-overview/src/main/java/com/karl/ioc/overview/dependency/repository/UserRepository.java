package com.karl.ioc.overview.dependency.repository;

import com.karl.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * 描述:  用户信息仓库
 *
 * @author mh
 * @create 2020-03-31 21:32
 */
public class UserRepository {

    Collection<User> userCollection; // 自定义的Bean

    private BeanFactory beanFactory; // 内建的非用户自定义的Bean（依赖）

    public ObjectFactory<User> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<User> objectFactory) {
        this.objectFactory = objectFactory;
    }

    private ObjectFactory<User> objectFactory;



    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


}