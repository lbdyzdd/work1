package com.company.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Emp {
    private int empno;
    private String ename;
    private BigDecimal sal;
    private Date hiredate;
    private Integer deptno;

    public Emp(String ename, BigDecimal sal, Date hiredate) {
        this.ename = ename;
        this.sal = sal;
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                ", hiredate=" + hiredate +
                ", deptno=" + deptno +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Emp(String ename, BigDecimal sal, Date hiredate, Integer deptno) {
        this.ename = ename;
        this.sal = sal;
        this.hiredate = hiredate;
        this.deptno = deptno;
    }

    public Emp(int empno, String ename, BigDecimal sal, Date hiredate, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.sal = sal;
        this.hiredate = hiredate;
        this.deptno = deptno;
    }

    public Emp() {
    }
}
