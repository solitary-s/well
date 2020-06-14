package com.aloneness.well.tool.mapper;

import com.aloneness.well.tool.domain.EmpEmployee;

public interface EmpEmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EmpEmployee record);

    int insertSelective(EmpEmployee record);

    EmpEmployee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmpEmployee record);

    int updateByPrimaryKey(EmpEmployee record);
}