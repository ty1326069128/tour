package com.tangyuan.base.dal;



import cn.hutool.json.JSONUtil;

import java.io.Serializable;
import java.lang.reflect.Field;

public class BaseDTO implements Serializable {

    public String build(String template) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldValue = "";
            try {
                fieldValue= JSONUtil.toJsonStr(field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            String flagChar = "#" + fieldName + "#";
            template = template.replace(flagChar, fieldValue);
        }
        return template;
    }
}
