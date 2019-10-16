package com.note.Service;



import com.note.Model.Dept;

import java.util.List;

public interface DeptService {
    //新增科室
   void AddDept(Dept dept);

    //通过科室名查询科室信息
    Dept selectDeptByName(String deptName);

    //更新科室设置
    int updateDeptByDept(Dept dept);
    //获取所有科室
    List<Dept> getAllDeptInfo(Dept dept);

    //根据deptId获取科室详细信息
    Dept getDeptById(Integer deptId);

    //更新科室信息
    int  updateDept(Dept dept);
    //
    int updateDeptStatus(Dept dept);

    //根据科室名查询科室ID
   Dept getDeptByName(String deptName);

   //通过deptId删除科室信息
  void deleteDeptById(Integer deptId);
}
