package com.aloneness.well.mybatis.domain;

import com.aloneness.well.framework.response.ResponseInfo;
import lombok.*;

import java.util.List;

/**
 * 分页信息
 *
 * @author: tong
 * @create: 2020-06-04 22:46
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> extends ResponseInfo<T> {

    private long total;

    private List<T> rows;
}
