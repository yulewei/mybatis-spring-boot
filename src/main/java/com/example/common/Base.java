package com.example.common;

import com.alibaba.fastjson.JSON;

/**
 * @author yulewei on 2018/7/13
 */
public abstract class Base {

    public String toString() {
        return JSON.toJSONString(this);
    }

}
