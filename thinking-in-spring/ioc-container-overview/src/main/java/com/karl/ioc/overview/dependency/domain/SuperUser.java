package com.karl.ioc.overview.dependency.domain;

import com.karl.ioc.overview.dependency.annotion.Super;

/**
 * 描述:  超级用户
 *
 * @author mh
 * @create 2020-03-31 20:48
 */
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}