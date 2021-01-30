package com.example.common.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alicp.jetcache.support.AbstractValueEncoder;
import com.alicp.jetcache.support.CacheEncodeException;

/**
 * https://github.com/alibaba/jetcache/wiki/FAQ_CN
 */
public class FastjsonValueEncoder extends AbstractValueEncoder {

    protected static int IDENTITY_NUMBER = 0x4A953A81;

    public FastjsonValueEncoder(boolean useIdentityNumber) {
        super(useIdentityNumber);
    }

    @Override
    public byte[] apply(Object value) {
        try {
            byte[] bs1 = JSON.toJSONBytes(value, SerializerFeature.WriteClassName);
            if (useIdentityNumber) {
                byte[] bs2 = new byte[bs1.length + 4];
                writeHeader(bs2, IDENTITY_NUMBER);
                System.arraycopy(bs1, 0, bs2, 4, bs1.length);
                return bs2;
            } else {
                return bs1;
            }
        } catch (Exception e) {
            throw new CacheEncodeException("Fastjson Encode error. " + "msg=" + e.getMessage(), e);
        }
    }
}