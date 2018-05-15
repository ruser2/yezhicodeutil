package com.yllt.com.framework.json.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.yllt.enumeration.RegexType;

/*
 * 9ijf
 * 字段注解，用于验证、生成文档等
 * @author Sean Lai
 * @version 1.0,2011/8/15
 * Copyright (c) 2011.
 */

@Target({ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
//TODO 待实现数组参数的校验
public @interface Field {

    //是否可以为空
    boolean nullable() default false;
    //最大长度
    int maxLength() default 0;
    //最小长度
    int minLength() default 0;
    //提供几种常用的正则验证
    RegexType regexType() default RegexType.NONE;
    //自定义正则验证
    String regexExpression() default "";
    //参数或者字段描述,这样能够显示友好的异常信息
    String description() default "";


}
