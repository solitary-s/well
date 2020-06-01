package com.aloneness.well.framework.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: tong
 * @create: 2020-06-01 20:37
 */
@Setter
@Getter
@ToString
public class User {
    private String name;

    private Integer age;

    private LocalDateTime localDateTime;

    private LocalDate localDate;

    private LocalTime localTime;

    private Long bigNum;
}
