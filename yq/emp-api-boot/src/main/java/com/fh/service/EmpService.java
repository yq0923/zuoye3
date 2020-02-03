package com.fh.service;

import com.fh.model.*;

import java.util.List;

public interface EmpService {
    DataTableResult queryEmpList(EmpQuery empQuery);

    void addEmp(Emp emp);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    void deleteEmp(Integer id);

    void batchDeleteEmp(List<Integer> ids);

    List<Dept> queryDeptList();

    List<Job> queryJobList();
}
