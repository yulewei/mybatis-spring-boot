package com.example.common.cache;

import com.alibaba.fastjson.JSON;
import com.alicp.jetcache.support.AbstractValueDecoder;

/**
 * https://github.com/alibaba/jetcache/wiki/FAQ_CN
 */
public class FastjsonValueDecoder extends AbstractValueDecoder {

    public FastjsonValueDecoder(boolean useIdentityNumber) {
        super(useIdentityNumber);
    }

    @Override
    public Object doApply(byte[] buffer) {
        if (useIdentityNumber) {
            byte[] bs = new byte[buffer.length - 4];
            System.arraycopy(buffer, 4, bs, 0, bs.length);
            return JSON.parse(bs);
        } else {
            return JSON.parse(buffer);
        }
    }
}