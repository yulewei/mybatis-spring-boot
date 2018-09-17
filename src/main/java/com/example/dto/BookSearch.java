package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yulewei on 2018/5/2
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookSearch {

    protected Integer page;

    @Builder.Default
    protected Integer limit = 20;

    protected String orderBy;

}
