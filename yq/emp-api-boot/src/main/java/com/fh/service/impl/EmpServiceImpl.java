package com.fh.service.impl;

import com.fh.mapper.EmpMapper;
import com.fh.model.*;
import com.fh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public DataTableResult queryEmpList(EmpQuery empQuery) {

        //1.查询总条数
        Long count = empMapper.queryEmpCount(empQuery);

        //2.分页条件查询当前页数据
        List<Emp> empList = empMapper.queryEmpList(empQuery);

        //3.构造DataTableResult对象
        DataTableResult dataTableResult = new DataTableResult(empQuery.getDraw(), count, count, empList);

        return dataTableResult;
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
    }

    @Override
    public void deleteEmp(Integer id) {
        empMapper.deleteEmp(id);
    }

    @Override
    public void batchDeleteEmp(List<Integer> ids) {
        empMapper.batchDeleteEmp(ids);
    }


    @Override
    public List<Dept> queryDeptList() {
        return empMapper.queryDeptList();
    }

    @Override
    public List<Job> queryJobList() {
        return empMapper.queryJobList();
    }
}
