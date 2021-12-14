package com.company.controller.vo;

import java.math.BigDecimal;
import java.util.Date;

public class EmpVO {
    private Integer empno;
    private String ename;
    private BigDecimal lowSal;
    private BigDecimal hiSal;
    private Date begin;
    private Date end;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public BigDecimal getLowSal() {
        return lowSal;
    }

    public void setLowSal(BigDecimal lowSal) {
        this.lowSal = lowSal;
    }

    public BigDecimal getHiSal() {
        return hiSal;
    }

    public void setHiSal(BigDecimal hiSal) {
        this.hiSal = hiSal;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public EmpVO() {
    }
}
