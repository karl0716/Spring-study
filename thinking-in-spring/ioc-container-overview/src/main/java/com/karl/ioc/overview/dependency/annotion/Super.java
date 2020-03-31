package com.karl.ioc.overview.dependency.annotion;


import org.springframework.stereotype.Indexed;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //@Target 表示这个注解放到什么上面来  ElementType.TYPE 标识class/interface 上面来
@Retention(RetentionPolicy.RUNTIME) // 保留的一种策略 运行时 可以被反射读取到
public @interface Super {

}
