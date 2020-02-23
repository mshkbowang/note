package com.note.Model;



public class Dept {
    private Integer deptId;
    private String deptName;//科室名字
    private String deptDes;//科室描述
    private String status;
    private String deptArea;//科室位置
    private Dept dept;

    public Dept(String deptName, String deptDes, String status, String deptArea) {
        this.deptName = deptName;
        this.deptDes = deptDes;
        this.status = status;
        this.deptArea = deptArea;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptDes='" + deptDes + '\'' +
                ", status='" + status + '\'' +
                ", deptArea='" + deptArea + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Dept() {
    }

    public Dept(Integer deptId, String deptName, String deptDes, String status, String deptArea, Dept dept) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptDes = deptDes;
        this.status = status;
        this.deptArea = deptArea;
        this.dept = dept;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDes() {
        return deptDes;
    }

    public void setDeptDes(String deptDes) {
        this.deptDes = deptDes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeptArea() {
        return deptArea;
    }

    public void setDeptArea(String deptArea) {
        this.deptArea = deptArea;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}