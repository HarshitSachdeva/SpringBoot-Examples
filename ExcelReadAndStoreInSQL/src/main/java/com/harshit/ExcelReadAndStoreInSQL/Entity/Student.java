package com.harshit.ExcelReadAndStoreInSQL.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private Integer studentId;
    private String sname;
    private  String fname;

    public Integer getStudentId() {
        return studentId;
    }

    public Student(Integer studentId, String sname, String fname) {
        this.studentId = studentId;
        this.sname = sname;
        this.fname = fname;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Student() {
    }


}
