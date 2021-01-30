package com.example.common.cache;

import com.alicp.jetcache.support.AbstractValueEncoder;
import com.alicp.jetcache.support.CacheEncodeException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.util.TimeZone;

/**
 * @author yulewei on 2019-09-03
 */
public class MsgPackValueEncoder extends AbstractValueEncoder {

    public static ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());

    static {
        mapper.setTimeZone(TimeZone.getDefault());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);  // 只输出非 null
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
    }

    public MsgPackValueEncoder(boolean useIdentityNumber) {
        super(false);
    }

    @Override
    public byte[] apply(Object o) {
        try {
            return mapper.writeValueAsBytes(o);
        } catch (Exception e) {
            throw new CacheEncodeException("MsgPack Encode error. " + "msg=" + e.getMessage(), e);
        }
    }
}
