package com.aloneness.well.tool.domain;

import com.aloneness.well.mybatis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * gen_table
 *
 * @author: tong
 * @create: 2020-06-04 23:30
 */
@Setter
@Getter
@ToString
public class GenTable extends BaseEntity {

    /** 编号 */
    private Long tableId;

    /** 表名称 */
    private String tableName;

    /** 表描述 */
    private String tableComment;

    /** 实体类名称(首字母大写) */
    private String className;

    /** 使用的模板（crud单表操作 tree树表操作） */
    private String tplCategory;

    /** 生成包路径 */
    private String packageName;

    /** 生成模块名 */
    private String moduleName;

    /** 生成业务名 */
    private String businessName;

    /** 生成功能名 */
    private String functionName;

    /** 生成作者 */
    private String functionAuthor;

    /** 主键信息 */
    private GenTableColumn pkColumn;

    /** 表列信息 */
    private List<GenTableColumn> columns;

    /** 其它生成选项 */
    private String options;

    /** 树编码字段 */
    private String treeCode;

    /** 树父编码字段 */
    private String treeParentCode;

    /** 树名称字段 */
    private String treeName;
}
