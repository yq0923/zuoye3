package com.fh.controller;

import com.fh.model.*;
import com.fh.service.EmpService;
import com.fh.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("EmpController")
public class EmpController {

    @Autowired
    private EmpService empService;


    @RequestMapping("queryDeptList")
    public ServerResponse queryDeptList() {
        List<Dept> deptList = empService.queryDeptList();
        return ServerResponse.success(deptList);
    }

    @RequestMapping("queryJobList")
    public ServerResponse queryJobList() {
        List<Job> jobList = empService.queryJobList();
        return ServerResponse.success(jobList);
    }

    //分页条件查询信息
    @RequestMapping("queryEmpList")
    public ServerResponse queryEmpList(EmpQuery empQuery) {
        DataTableResult dataTableResult = empService.queryEmpList(empQuery);
        return ServerResponse.success(dataTableResult);
    }

    //新增
    @RequestMapping("addEmp")
    public ServerResponse addEmp(Emp emp) {
        empService.addEmp(emp);
        return ServerResponse.success();
    }

    //通过id获取单个信息
    @RequestMapping("getEmpById")
    public ServerResponse getEmpById(Integer id) {
        Emp emp = empService.getEmpById(id);
        return ServerResponse.success(emp);
    }

    //修改
    @RequestMapping("updateEmp")
    public ServerResponse updateEmp(Emp emp) {
        empService.updateEmp(emp);
        return ServerResponse.success();
    }

    @RequestMapping("deleteEmp")
    public ServerResponse deleteEmp(Integer id) {
        empService.deleteEmp(id);
        return ServerResponse.success();
    }

    @RequestMapping("batchDeleteEmp")
    public ServerResponse batchDeleteEmp(@RequestParam("ids[]") List<Integer> ids) {
        empService.batchDeleteEmp(ids);
        return ServerResponse.success();
    }

    //上传用户图片
    @RequestMapping("uploadFile")
    @ResponseBody
    public ServerResponse uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        try {
            String filePath = FileUtil.uploadFile(request,file,"/zhangxuhao");
            return ServerResponse.success(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
