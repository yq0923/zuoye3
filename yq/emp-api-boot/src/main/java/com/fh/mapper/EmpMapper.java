package com.fh.mapper;

import com.fh.model.Dept;
import com.fh.model.Emp;
import com.fh.model.EmpQuery;
import com.fh.model.Job;

import java.util.List;

public interface EmpMapper {
    List<Emp> queryEmpList(EmpQuery empQuery);

    Long queryEmpCount(EmpQuery empQuery);

    void addEmp(Emp emp);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    void deleteEmp(Integer id);

    void batchDeleteEmp(List<Integer> ids);

    List<Dept> queryDeptList();

    List<Job> queryJobList();
}
