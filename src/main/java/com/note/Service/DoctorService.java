package com.note.Service;

import java.util.List;

import com.note.Model.Doctor;

public interface DoctorService {
	//添加医生
	void AddDoctor(Doctor doctor);
	
	Doctor selectDoctorByName(String doctorName);

	//获取医生总数
	List<Doctor> getAllDoctorInfo(Doctor doctor);

	//获取医生的详细信息
	List<Doctor> getAllDoctorInfoDetail(Doctor doctor);

	//获取所有医生信息
	List<Doctor> getAllDoctorInfo1(Doctor doctor);

	//通过doctorId获取医生的记录
	Doctor getDoctorById(Integer doctorId);
	//根据查询结果修改医生信息
	boolean updateDoctor(Doctor doc);
	//修改医生状态
	int updateDocWorkStatus(Doctor doc);

	//删除医生记录
	void deleteDoctorInfo(Integer docId);

	//通过deptId获取所有医生的信息
	List<Doctor> getDoctorByDeptId(Integer deptId);

	//通过doctorId查询医生的详细信息
	Doctor  selectDoctorInfo(Integer doctorId);

	Doctor getAllDoctorInfo2(Integer doctorId);
}
