package com.mine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <简述>
 *      自定义注解，用于用户操作日志记录
 * @Auther: feixiang
 * @Date: 2018/8/22 16:22
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLogAnnotation {
    String description() default "自定义描述";
}
