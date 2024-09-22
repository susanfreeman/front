package com.ruoyi.common.utils.mask;

import java.lang.reflect.Field;
import java.util.Collections;

public class MaskUtils {

    public static String maskcommonValue(String commonValue, CommonMask CommonMask) {
        int start = CommonMask.start();
        int end = CommonMask.end();

        if (commonValue == null || commonValue.length() == 0 || commonValue.length() <= start || commonValue.length() <= end) {
            return commonValue;
        }

        String maskedNumber = String.join("",
                commonValue.substring(0, commonValue.length()>=start?start:commonValue.length()),
                String.join("", Collections.nCopies(Math.abs(commonValue.length() - start - end), "*")),
                commonValue.substring(commonValue.length() - end));

        return maskedNumber;
    }

    public static void maskFields(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                CommonMask CommonMask = field.getAnnotation(CommonMask.class);
                if (CommonMask != null) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (value instanceof String) {
                        String maskedValue = maskcommonValue((String) value, CommonMask);
                        field.set(obj, maskedValue);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
