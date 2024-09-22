package com.ruoyi.common.utils.mask;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonMask {
    int start() default 0; // 掩码开始位置，例如4表示保留前4位数字

    int end() default 0; // 掩码结束位置，例如8表示保留后4位数字
}
