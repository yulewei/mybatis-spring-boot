package com.example.common.maxwell;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author yulewei on 2021/1/4
 */
public class MaxwellConverter {

    @SuppressWarnings("unchecked")
    public static <O> MaxwellLog<O> parse(String payload, Class<O> clazz) {
        MaxwellLog<JSONObject> tmp = JSON.parseObject(payload, MaxwellLog.class);
        O data = null;
        if (tmp.getData() != null) {
            data = tmp.getData().toJavaObject(clazz);
        }
        O old = null;
        if (tmp.getOld() != null) {
            old = tmp.getOld().toJavaObject(clazz);
        }

        MaxwellLog<O> log = new MaxwellLog<>();
        log.setDatabase(tmp.getDatabase());
        log.setTable(tmp.getTable());
        log.setType(tmp.getType());
        log.setTs(tmp.getTs());
        log.setXid(tmp.getXid());
        log.setCommit(tmp.isCommit());
        log.setData(data);
        log.setOld(old);
        return log;
    }
}
