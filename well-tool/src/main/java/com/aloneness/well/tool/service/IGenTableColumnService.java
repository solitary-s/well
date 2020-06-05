package com.aloneness.well.tool.service;

import com.aloneness.well.tool.domain.GenTableColumn;

import java.util.List;

/**
 * service
 *
 * @author liaoshitong
 * @date 2020/6/5
 */
public interface IGenTableColumnService {
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);

    int insertGenTableColumn(GenTableColumn genTableColumn);

    int updateGenTableColumn(GenTableColumn genTableColumn);

    int deleteGenTableColumnByIds(String ids);
}
