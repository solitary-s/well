package com.aloneness.well.tool.controller;

import cn.hutool.core.convert.Convert;
import com.aloneness.well.mybatis.controller.BaseController;
import com.aloneness.well.mybatis.domain.PageInfo;
import com.aloneness.well.tool.domain.GenTable;
import com.aloneness.well.tool.domain.GenTableColumn;
import com.aloneness.well.tool.service.IGenTableColumnService;
import com.aloneness.well.tool.service.IGenTableService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liaoshitong
 * @date 2020/6/8
 */
@RestController
@RequestMapping("/tool/gen")
public class GenController extends BaseController {

    @Autowired
    private IGenTableService genTableService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

    /**
     * 查询代码生成列表
     */
    @GetMapping("/list")
    public PageInfo<GenTable> genList(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectGenTableList(genTable);
        return getPageInfo(list);
    }

    /**
     * 修改代码生成业务
     */
    @GetMapping(value = "/{talbleId}")
    public Map<String, Object> getInfo(@PathVariable Long talbleId) {
        GenTable table = genTableService.selectGenTableById(talbleId);
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(talbleId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("info", table);
        map.put("rows", list);
        return map;
    }

    /**
     * 查询数据库列表
     */
    @GetMapping("/db/list")
    public PageInfo<GenTable> dataList(GenTable genTable) {
        startPage();
        List<GenTable> list = genTableService.selectDbTableList(genTable);
        return getPageInfo(list);
    }

    /**
     * 查询数据表字段列表
     */
    @GetMapping(value = "/column/{tableId}")
    public PageInfo<GenTableColumn> columnList(@PathVariable("tableId") Long tableId) {
        PageInfo<GenTableColumn> dataInfo = new PageInfo<GenTableColumn>();
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
        dataInfo.setRows(list);
        dataInfo.setTotal(list.size());
        return dataInfo;
    }

    /**
     * 导入表结构（保存）
     */
    @PostMapping("/importTable")
    public void importTableSave(String tables) {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        genTableService.importGenTable(tableList);
    }

    /**
     * 修改保存代码生成业务
     */
    @PutMapping
    public void editSave(@Validated @RequestBody GenTable genTable) {
        //System.out.println(genTable.getParams().size());
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
    }

    @DeleteMapping("/{tableIds}")
    public void remove(@PathVariable Long[] tableIds) {
        genTableService.deleteGenTableByIds(tableIds);
    }

    /**
     * 预览代码
     */
    @GetMapping("/preview/{tableId}")
    public Map<String, String> preview(@PathVariable("tableId") Long tableId) throws IOException {
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return dataMap;
    }

    /**
     * 生成代码
     */
    @GetMapping("/genCode/{tableName}")
    public void genCode(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = genTableService.generatorCode(tableName);
        genCode(response, data);
    }

    /**
     * 批量生成代码
     */
    @GetMapping("/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.generatorCode(tableNames);
        genCode(response, data);
    }

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"luopeng.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}
