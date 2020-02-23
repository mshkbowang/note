package com.note.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.print.Doc;


import com.note.Model.Dept;
import com.note.Service.DeptService;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.note.Model.Doctor;
import com.note.Service.DoctorService;

@Controller
public class DoctorController {

    @Resource
    private DoctorService docService;
    @Resource
    private DeptService deptService;

    //新增医生信息
    @RequestMapping("addDoc.do")
    @ResponseBody
    public String add(Doctor doctor) {
       // System.out.println(doctor);
        String result = "";
        Doctor doc1 = null;
        try {
            doc1 = docService.selectDoctorByName(doctor.getDoctorName());
            Integer id = doc1.getDoctorId();
            if (id != null) {
                result = "exists";
            }
        } catch (Exception e) {
            Dept dept = deptService.getDeptByName(doctor.getDeptName());
            if (dept != null) {
                doctor.setDeptId(dept.getDeptId());
                doctor.setWorkStatus(1);
                doctor.setStatus("1");
                docService.AddDoctor(doctor);
                int pid = doctor.getDoctorId();
                //System.out.println(pid);
                result = "success";
            }
        }
        return result;
    }
    //查询所有医生的信息
    @RequestMapping("getDocList.do")
    @ResponseBody
    public List<Doctor> getDocLists() {
        List<Doctor> doctList = null;
        try {
            Doctor doctor = new Doctor();
            doctList = docService.getAllDoctorInfo(doctor);
            Integer length = doctList.size();
            if (length > 0) {
                return doctList;
            }
        } catch (Exception e) {
        }
        return doctList;
    }

    //查询所有医生的详细信息
    @RequestMapping("getDocListInfo.do")
    @ResponseBody
    public List<Doctor> getDocListInfo() {
        List<Doctor> doctListInfo = null;
        try {
            Doctor doctor = new Doctor();
            doctListInfo = docService.getAllDoctorInfoDetail(doctor);
            Integer length = doctListInfo.size();
            if (length > 0) {
                return doctListInfo;
            }
        } catch (Exception e) {
        }
        return doctListInfo;
    }
    //查询所有拥有科室的医生信息
    @RequestMapping("getDocList1.do")
    @ResponseBody
    public List<Doctor> getDocLists1() {
        List<Doctor> doctList = null;
        try {
            Doctor doctor = new Doctor();
            doctList = docService.getAllDoctorInfo1(doctor);
            Integer length = doctList.size();
            if (length > 0) {
                return doctList;
            }
        } catch (Exception e) {
        }
        return doctList;
    }
    //通过doctorId获取医生的详细信息
    @RequestMapping("getDocById.do")
	@ResponseBody
	public Doctor getDeptById(Integer doctorId) {
       // System.out.println("**************"+doctorId);
		Doctor doc = null;
        try{
            Doctor doc1=docService.getDoctorById(doctorId);
            Dept dept1=deptService.getDeptById(doc1.getDeptId());
            doc1.setDeptName(dept1.getDeptName());
            doc=doc1;
        }catch (Exception e){

        }
        return doc;
	}
    //根据查询结果更新医生信息
	@RequestMapping("updateDoc.do")
	@ResponseBody
	public String updateDoc(Doctor doc) {
        //System.out.println(doc);
		String result = "";
		try{
		    //返回一个boolean值
            Boolean b=docService.updateDoctor(doc);
			if(b) {
				result = "success";
			}
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}

    //根据doctorId修改医生状态
    @RequestMapping("updateDocWorkStatus.do")
    @ResponseBody
    public String updateDocStatus(Doctor doc) {
      //  System.out.println(doc);
        int w=doc.getWorkStatus();
       // System.out.println(w);
        String result = "";
        try {
            if(w==1){
                doc.setWorkStatus(0);
                int id=docService.updateDocWorkStatus(doc);
                result="success";
            }else{
                doc.setWorkStatus(1);
                int id=docService.updateDocWorkStatus(doc);
                result="success";
            }
        }catch (Exception e){
            result="error";
        }

        return result;
    }

    //删除医生记录
    @RequestMapping("deleteDoctorInfo.do")
    @ResponseBody
    public String deleteDoctorInfo(Doctor doc) {
      //  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$"+doc);

        String result = "";
        try {
            docService.deleteDoctorInfo(doc.getDoctorId());
            result = "success";
        } catch (Exception e) {
            result = "error";
        }
        return result;
    }
    //通过deptId获取医生信息
	@RequestMapping("getDoctorByDeptId.do")
	@ResponseBody
	public List<Doctor> getDoctorByDeptId(Doctor doc) {
		List<Doctor> doctList = null;
	//	int id = doc.getDeptId();
		try{
		    doctList = docService.getDoctorByDeptId(doc.getDeptId());
			Integer length = doctList.size();
    		if(length > 0) {
				return doctList;
			}
		}catch(Exception e) {
		}
		//System.out.println(doctList);
		return doctList;
	}

}