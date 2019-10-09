package com.note.Model;


import java.util.Date;

public class Order {
  private Integer orderId;
  private Integer userId;
  private Integer doctorId;
  private Integer wStatus;
  private Date createTime;
  private Date registerTime;
  private String doctorName;
  private String deptName;
  private String wName;
  private String address;
  private String tel;
  private Order order;

    public Order() {

    }

    public Order(Integer userId, Integer doctorId, Date createTime, Date registerTime) {
        this.userId = userId;
        this.doctorId = doctorId;
        this.createTime = createTime;
        this.registerTime = registerTime;
    }

    public Order(Integer orderId, Integer userId, Integer doctorId, Integer wStatus, Date createTime, Date registerTime, String doctorName, String deptName, String wName, String address, String tel, Order order) {
        this.orderId = orderId;
        this.userId = userId;
        this.doctorId = doctorId;
        this.wStatus = wStatus;
        this.createTime = createTime;
        this.registerTime = registerTime;
        this.doctorName = doctorName;
        this.deptName = deptName;
        this.wName = wName;
        this.address = address;
        this.tel = tel;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", doctorId=" + doctorId +
                ", wStatus=" + wStatus +
                ", createTime=" + createTime +
                ", registerTime=" + registerTime +
                ", doctorName='" + doctorName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", wName='" + wName + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", order=" + order +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getWStatus() {
        return wStatus;
    }

    public void setWStatus(Integer wStatus) {
        this.wStatus = wStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptNmae) {
        this.deptName = deptNmae;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
