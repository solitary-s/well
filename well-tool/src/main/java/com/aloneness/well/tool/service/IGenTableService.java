package com.aloneness.well.tool.service;

import com.aloneness.well.tool.domain.GenTable;

import java.util.List;
import java.util.Map;

/**
 * service
 *
 * @author liaoshitong
 * @date 2020/6/5
 */
public interface IGenTableService {
    List<GenTable> selectGenTableList(GenTable genTable);

    List<GenTable> selectDbTableList(GenTable genTable);

    List<GenTable> selectDbTableListByNames(String[] tableNames);

    GenTable selectGenTableById(Long id);

    void updateGenTable(GenTable genTable);

    void deleteGenTableByIds(Long[] tableIds);

    void importGenTable(List<GenTable> tableList);

    Map<String, String> previewCode(Long tableId);

    byte[] generatorCode(String tableName);

    byte[] generatorCode(String[] tableNames);

    void validateEdit(GenTable genTable);
}
