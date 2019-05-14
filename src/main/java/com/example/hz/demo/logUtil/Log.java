package com.example.hz.demo.logUtil;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Log {
    String before() default "" ;

    String after() default "";

}
