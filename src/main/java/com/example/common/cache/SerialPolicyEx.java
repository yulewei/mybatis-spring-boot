package com.example.common.cache;

import com.alicp.jetcache.anno.SerialPolicy;

public interface SerialPolicyEx extends SerialPolicy {

    String FASTJSON = "fastjson";

    String MSGPACK = "msgpack";

}
