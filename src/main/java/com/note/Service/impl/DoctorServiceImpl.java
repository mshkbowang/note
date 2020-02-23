package com.note.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.Dao.DoctorDao;
import com.note.Model.Doctor;
import com.note.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao docDao;  
	
	 public Doctor selectDoctorByName(String doctorName){
	      return docDao.selectDoctorByName(doctorName);
	 }
	 //添加医生信息
	 public void AddDoctor(Doctor doctor){
	       docDao.AddDoctor(doctor);
	 }	 
	 //获取医生总数
	 public List<Doctor> getAllDoctorInfo(Doctor doctor) {
		 return docDao.getAllDoctorInfo(doctor);
	 }

	 //获取医生的详细信息
	public List<Doctor> getAllDoctorInfoDetail(Doctor doctor) {
		return docDao.getAllDoctorInfoDetail(doctor);
	}

	//获取所有医生信息
	 public List<Doctor> getAllDoctorInfo1(Doctor doctor){
	 	return docDao.getAllDoctorInfo1(doctor);
	 }
	 
	 //通过doctorId获取医生的记录
	 public Doctor getDoctorById(Integer doctorId) {
		 return docDao.getDoctorById(doctorId);
	 }
	 //根据查询的结果修改医生的信息
	 public boolean updateDoctor(Doctor doc) {
		 return docDao.updateDoctor(doc);
	 }

	 //删除医生状态
	 public void deleteDoctorInfo(Integer docId) {
		 docDao.deleteDoctorInfo(docId);
	 }
	 //修改医生状态
	 public int updateDocWorkStatus(Doctor doc) {
		 return docDao.updateDocWorkStatus(doc);
	 }
	 //通过deptId获取医生信息
	 public List<Doctor> getDoctorByDeptId(Integer deptId){
		 return docDao.getDoctorByDeptId(deptId);
	 }
	//通过doctorId查询医生的详细信息
	public Doctor selectDoctorInfo(Integer doctorId){
	 	return docDao.selectDoctorInfo(doctorId);
	}
	public Doctor getAllDoctorInfo2(Integer doctorId){
	     return docDao.getAllDoctorInfo2(doctorId);
    }

}
