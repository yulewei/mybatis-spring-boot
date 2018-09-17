package com.example.enums;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟实现 enum
 *
 * https://dubbo.gitbooks.io/dubbo-user-book/content/references/protocol/dubbo.html#%E7%BA%A6%E6%9D%9F
 *
 * @author yulewei on 2018/4/30
 */
public abstract class EnumBase implements Serializable {

    private static Map<String, Object> values = new HashMap<>();

    abstract String getCode();

    EnumBase() {
    }

    EnumBase(String code) {
        values.put(code, this);
    }

    public static <E> E parse(String code) {
        return (E) values.get(code);
    }

}
