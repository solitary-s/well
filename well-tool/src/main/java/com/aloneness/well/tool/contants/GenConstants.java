package com.aloneness.well.tool.contants;

/**
 * 字符常量
 *
 * @author liaoshitong
 * @date 2020/6/5
 */
public interface GenConstants {

    String TPL_CRUD = "crud";
    String TPL_TREE = "tree";
    String TREE_CODE = "treeCode";
    String TREE_PARENT_CODE = "treeParentCode";
    String TREE_NAME = "treeName";
    String[] COLUMNTYPE_STR = new String[]{"char", "varchar", "narchar", "varchar2", "tinytext", "text", "mediumtext", "longtext"};
    String[] COLUMNTYPE_TIME = new String[]{"datetime", "time", "date", "timestamp"};
    String[] COLUMNTYPE_NUMBER = new String[]{"tinyint", "smallint", "mediumint", "int", "number", "integer", "bigint", "float", "float", "double", "decimal"};
    String[] COLUMNNAME_NOT_EDIT = new String[]{"id", "create_by", "create_time", "del_flag"};
    String[] COLUMNNAME_NOT_LIST = new String[]{"id", "create_by", "create_time", "del_flag", "update_by", "update_time"};
    String[] COLUMNNAME_NOT_QUERY = new String[]{"id", "create_by", "create_time", "del_flag", "update_by", "update_time", "remark"};
    String[] BASE_ENTITY = new String[]{"createBy", "createTime", "updateBy", "updateTime", "remark"};
    String[] TREE_ENTITY = new String[]{"parentName", "parentId", "orderNum", "ancestors", "children"};
    String HTML_INPUT = "input";
    String HTML_TEXTAREA = "textarea";
    String HTML_SELECT = "select";
    String HTML_RADIO = "radio";
    String HTML_CHECKBOX = "checkbox";
    String HTML_DATETIME = "datetime";
    String TYPE_STRING = "String";
    String TYPE_INTEGER = "Integer";
    String TYPE_LONG = "Long";
    String TYPE_DOUBLE = "Double";
    String TYPE_BIGDECIMAL = "BigDecimal";
    String TYPE_DATE = "Date";
    String QUERY_LIKE = "LIKE";
    String REQUIRE = "1";
}
