package com.aloneness.well.tool.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.aloneness.well.tool.domain.EmpEmployee;
import com.aloneness.well.tool.mapper.EmpEmployeeMapper;
import com.aloneness.well.tool.service.impl.EmpEmployeeService;
@Service
public class EmpEmployeeServiceImpl implements EmpEmployeeService{

    @Resource
    private EmpEmployeeMapper empEmployeeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return empEmployeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EmpEmployee record) {
        return empEmployeeMapper.insert(record);
    }

    @Override
    public int insertSelective(EmpEmployee record) {
        return empEmployeeMapper.insertSelective(record);
    }

    @Override
    public EmpEmployee selectByPrimaryKey(Long id) {
        return empEmployeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EmpEmployee record) {
        return empEmployeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(EmpEmployee record) {
        return empEmployeeMapper.updateByPrimaryKey(record);
    }

}
