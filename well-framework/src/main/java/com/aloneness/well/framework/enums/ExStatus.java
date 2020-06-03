package com.aloneness.well.framework.enums;

/**
 * 异常状态枚举
 *
 * @author: tong
 * @create: 2020-06-03 22:13
 */
public enum ExStatus {

    HIT(1, "命中"), SKIP(2, "跳过"), RETURN(3, "返回");

    private Integer value;

    private String name;

    private ExStatus(Integer value, String name) {
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
