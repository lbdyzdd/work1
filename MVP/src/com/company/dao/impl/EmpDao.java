package com.company.dao.impl;

import com.company.controller.vo.EmpVO;
import com.company.dao.entity.Emp;
import com.company.dao.idao.IEmpDao;
import com.company.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao implements IEmpDao {
    @Override
    public int save(Emp emp) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "insert into aemp(empno,ename,sal,hiredate,deptno) values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,emp.getEmpno());
        ps.setString(2,emp.getEname());
        ps.setBigDecimal(3,emp.getSal());
        ps.setDate(4,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setInt(5,emp.getDeptno());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public int delete(Emp emp) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "delete from aemp where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,emp.getEmpno());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public int update(Emp emp) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "update aemp set ename=?,sal=?,hiredate=?,deptno=? where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setBigDecimal(2,emp.getSal());
        ps.setDate(3,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setInt(4,emp.getDeptno());
        ps.setInt(5,emp.getEmpno());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public List<Emp> findByPage(int begin , int size) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "select empno,ename,sal,hiredate,deptno from aemp limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,begin);
        ps.setInt(2,size);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getBigDecimal(3),rs.getDate(4),rs.getInt(5));
            emps.add(emp);
        }
        return emps;
    }

    @Override
    public List<Emp> findByName(String name) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "select empno,ename,sal,hiredate,deptno from aemp where ename like concat('%',?,'%')";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getBigDecimal(3),rs.getDate(4),rs.getInt(5));
            emps.add(emp);
        }
        return emps;
    }

    @Override
    public Emp findById(Integer id) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select empno,ename,sal,hiredate,deptno from aemp where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Emp emp = null;
        if(rs.next()){
            emp = new Emp(rs.getInt(1),rs.getString(2),rs.getBigDecimal(3),rs.getDate(4),rs.getInt(5));
        }
        return emp;
    }

    @Override
    public List<Emp> findByDynamicSQL(EmpVO empVO) throws SQLException {
        Connection con = DBUtil.getConnection();
        StringBuilder sql = new StringBuilder("select empno,ename,sal,hiredate from aemp where 1=1");
        if(empVO.getEmpno() != null )  sql.append(" and empno=?");
        if(empVO.getEname() != null ) sql.append(" and ename like concat('%',?,'%')");
        if(empVO.getLowSal() != null ) sql.append(" and sal>?");
        if(empVO.getHiSal() != null ) sql.append(" and sal<?");
        if(empVO.getBegin() != null && empVO.getEname() != null) {
            sql.append(" and hiredate between ? and ?");
        }
        System.out.println("execute sql: "+sql.toString());
        PreparedStatement ps = con.prepareStatement(sql.toString());
        int i = 0;
        if(empVO.getEmpno() != null ){
            i++;
            ps.setInt(i,empVO.getEmpno());
        }
        if(empVO.getEname() != null ){
            i++;
            ps.setString(i,empVO.getEname());
        }
        if(empVO.getLowSal() != null ){
            i++;
            ps.setBigDecimal(i,empVO.getLowSal());
        }
        if(empVO.getHiSal() != null ){
            i++;
            ps.setBigDecimal(i,empVO.getHiSal());
        }
        if(empVO.getBegin() != null && empVO.getEname() != null) {
            i++;
            ps.setDate(i,new java.sql.Date(empVO.getBegin().getTime()));
            i++;
            ps.setDate(i,new java.sql.Date(empVO.getEnd().getTime()));
        }
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getBigDecimal(3),rs.getDate(4),rs.getInt(5));
            emps.add(emp);
        }
        return emps;

    }

    @Override
    public List<Emp> findAll() throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select empno,ename,sal,hiredate,deptno from aemp ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getBigDecimal(3),rs.getDate(4),rs.getInt(5));
            emps.add(emp);
        }
        return emps;
    }
}
