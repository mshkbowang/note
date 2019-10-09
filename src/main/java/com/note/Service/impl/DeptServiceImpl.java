package com.note.Service.impl;



import java.util.List;

import com.note.Dao.DeptDao;
import com.note.Model.Dept;
import com.note.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    //新增科室
    public void AddDept(Dept dept) {
        deptDao.AddDept(dept);
    }
    //通过科室名查询科室信息
    public Dept selectDeptByName(String deptName) {
        return deptDao.selectDeptByName(deptName);
    }

    public int updateDeptByDept(Dept dept) {
        return 0;
    }



    public List<Dept> getAllDeptInfo(Dept dept) {
        return deptDao.getAllDeptInfo(dept);
    }

    //根据deptId获取科室详细信息
    public Dept getDeptById(Integer deptId) {
        return deptDao.getDeptById(deptId);
    }

    public int updateDept(Dept dept) {
        return 0;
    }

    public int updateDeptStatus(Dept dept) {
        return 0;
    }



    //  //根据科室名查询科室ID
    public  Dept getDeptByName(String deptName){
        return deptDao.getDeptByName(deptName);
    }

    //通过deptId删除科室信息
    public void deleteDeptById(Integer deptId){
        deptDao.deleteDeptById(deptId);
    }
}



