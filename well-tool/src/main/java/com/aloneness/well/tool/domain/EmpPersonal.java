package com.aloneness.well.tool.domain;

import com.aloneness.well.mybatis.domain.BaseEntity;


import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.hutool.core.date.DatePattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * personal对象 e_emp_personal
 *
 * @author aloneness
 * @date 2020-06-12 15:49:42
 */
@Setter
@Getter
@ToString
public class EmpPersonal extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * EMP_ID
     */
    private Long empId;

    /**
     * 身份证号码
     */
    private String cardId;

    /**
     * 身份证姓名
     */
    private String cardName;

}