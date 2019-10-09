package com.note.Model;

public class Doctor {
	private Integer doctorId;
	private Integer deptId;//����id
	private String doctorName;//ҽ������
	private String doctorDes;//ҽ������
	private Integer workStatus;//�ϰ�״̬
	private String workTime;//�ϰ�ʱ��
	private String status;
	private Doctor doctor;
	private String deptName;

	public Doctor(Integer doctorId, Integer deptId, String doctorName, String doctorDes, Integer workStatus, String workTime, String status, Doctor doctor,String deptName) {
		this.doctorId = doctorId;
		this.deptId = deptId;
		this.doctorName = doctorName;
		this.doctorDes = doctorDes;
		this.workStatus = workStatus;
		this.workTime = workTime;
		this.status = status;
		this.doctor = doctor;
		this.deptName=deptName;
	}

	public Doctor(Integer deptId, String doctorName, String doctorDes, Integer workStatus, String workTime, String status) {
		this.deptId = deptId;
		this.doctorName = doctorName;
		this.doctorDes = doctorDes;
		this.workStatus = workStatus;
		this.workTime = workTime;
		this.status = status;

	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Doctor{" +
				"doctorId=" + doctorId +
				", deptId=" + deptId +
				", doctorName='" + doctorName + '\'' +
				", doctorDes='" + doctorDes + '\'' +
				", workStatus=" + workStatus +
				", workTime='" + workTime + '\'' +
				", status='" + status + '\'' +
				", doctor=" + doctor +
				", deptName='" + deptName + '\'' +
				'}';
	}

	public Doctor() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorDes() {
		return doctorDes;
	}
	public void setDoctorDes(String doctorDes) {
		this.doctorDes = doctorDes;
	}
	public Integer getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(Integer workStatus) {
		this.workStatus = workStatus;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
}
