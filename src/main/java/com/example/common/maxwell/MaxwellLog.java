package com.example.common.maxwell;

import com.example.common.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * https://maxwells-daemon.io/dataformat/
 *
 * @author yulewei on 2021/1/4
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaxwellLog<T> extends Base {

    private String database;

    private String table;

    private String type;

    private Long ts;

    private Long xid;

    private boolean commit;

    private T data;

    private T old;

}
