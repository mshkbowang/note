package com.note.Controller;

import java.util.List;

import javax.annotation.Resource;

import com.note.Model.Dept;
import com.note.Model.Doctor;
import com.note.Service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {

    @Resource
    private DeptService deptService;

    //添加科室信息
    @RequestMapping("addDept.do")
    @ResponseBody
    public String addDept(Dept dept) {
        System.out.println(dept);
        String result = "";
        Dept dept1 = null;
        try {
            dept1 = deptService.selectDeptByName(dept.getDeptName());
            Integer id = dept1.getDeptId();
            if (id != null) {
                result = "exists";
            }
        } catch (Exception e) {
            dept.setStatus("1");
                deptService.AddDept(dept);
                int pid = dept.getDeptId();
                System.out.println(pid);
                result="success";
        }
        System.out.println(result);
        return result;
    }

    //获取科室总数
    @RequestMapping("getDeptList.do")
    @ResponseBody
    public List<Dept> getDeptLists() {
        List<Dept> deptList = null;
        try{
            Dept dept=new Dept();
            dept.setStatus("1");
            deptList = deptService.getAllDeptInfo(dept);
            Integer length = deptList.size();
            //查询到数据 返回前台账号已存在
            if(length > 0) {
                return deptList;
            }
        }catch(Exception e) {
        }
        System.out.println(deptList);
        return deptList;
    }
        //通过deptId获取科室详细信息
    @RequestMapping("getDeptById.do")
    @ResponseBody
    public Dept getDeptById(Integer deptId) {
        System.out.println(deptId);
        Dept dep=null;
       try{
           Dept dept1=deptService.getDeptById(deptId);
           dep=dept1;
    }catch(Exception e) {
      }
        System.out.println(dep);
        return dep;
    }

//    @RequestMapping("updateDept.do")
//    @ResponseBody
//    public String updateDept(Department dept) {
//        System.out.println("update");
//        System.out.println(dept);
//        String result = "";
//
//        try{
//            int id = deptService.updateDept(dept);
//
//            if(id > 0) {
//                result = "success";
//            }
//        }catch(Exception e) {
//            result = "error";
//        }
//        return result;
//    }
//
    @RequestMapping("deleteDeptById.do")
    @ResponseBody
    public String deleteDeptById(Integer deptId) {
        String result = "";
        try{
             deptService.deleteDeptById(deptId);
                result = "success";
        }catch(Exception e) {
            result = "error";
        }
        return result;
    }

}
