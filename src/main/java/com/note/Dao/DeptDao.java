package com.note.Dao;


import com.note.Model.Dept;

import java.util.List;

/**
 * 描述:用户mapper接口
 *
 */
public interface DeptDao {
    //通过科室名查询科室信息
    Dept selectDeptByName(String deptName);

    //新增科室
    void AddDept(Dept dept);

    //更新科室
    int updateDeptByName(Dept dept);
    //获取所有科室信息
    List<Dept> getAllDeptInfo(Dept dept);

    //根据deptId查询科室详细信息
    Dept getDeptById(Integer deptId);

    int updateDept(Dept dept);

    int updateDeptStatus(Dept dept);

     //根据科室名查询科室ID
     Dept getDeptByName(String deptName);

     //通过deptId删除科室信息
    void deleteDeptById(Integer deptId);
}

