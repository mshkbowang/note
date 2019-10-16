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
        //System.out.println(dept+"~~~~~~~");
        String result = "";
        try {
            Dept dept1 = deptService.selectDeptByName(dept.getDeptName());
            Integer id = dept1.getDeptId();
            if (id != null) {
                result = "exists";
            }
        } catch (Exception e) {
            dept.setStatus("1");
            deptService.AddDept(dept);
            result = "success";
        }
        return result;
    }

    //获取所有科室的信息
    @RequestMapping("getDeptList.do")
    @ResponseBody
    public List<Dept> getDeptLists() {
        List<Dept> deptList = null;
        try {
            Dept dept = new Dept();
            dept.setStatus("1");
            deptList = deptService.getAllDeptInfo(dept);
            Integer length = deptList.size();
            //查询到数据 返回前台账号已存在
            if (length > 0) {
                return deptList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptList;
    }

    //通过deptId获取科室详细信息
    @RequestMapping("getDeptById.do")
    @ResponseBody
    public Dept getDeptById(Integer deptId) {
        Dept dep = null;
        try {
            dep = deptService.getDeptById(deptId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dep;
    }

    @RequestMapping("updateDept.do")
    @ResponseBody
    public String updateDept(Dept dept) {
        String result = "";
        try {
            int d = deptService.updateDept(dept);
            System.out.println("2348" + d);
            if (d > 0) {
                result = "success";
            }
        } catch (Exception e) {
            result = "error";
        }
        return result;
    }
    @RequestMapping("deleteDeptById.do")
    @ResponseBody
    public String deleteDeptById(Integer deptId) {
        String result = "";
        try {
            deptService.deleteDeptById(deptId);
            result = "success";
        } catch (Exception e) {
            result = "error";
        }
        return result;
    }

}
