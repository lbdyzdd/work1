package com.company.dao.impl;

import com.company.dao.entity.Dept;
import com.company.dao.idao.IDeptDao;
import com.company.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao implements IDeptDao {
    @Override
    public int save(Dept dept) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,dept.getDeptno());
        ps.setString(2,dept.getDname());
        ps.setString(3,dept.getLoc());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public int delete(Dept dept) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "delete from dept where deptno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,dept.getDeptno());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public int update(Dept dept) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "update dept set dname=?,loc=? where deptno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,dept.getDname());
        ps.setString(2,dept.getLoc());
        ps.setInt(3,dept.getDeptno());
        int flag = ps.executeUpdate();
        DBUtil.close(null,ps,con);
        return flag;
    }

    @Override
    public List<Dept> findAll() throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "select deptno,dname,loc from dept limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Dept> depts = new ArrayList<Dept>();
        while(rs.next()){
            Dept dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            depts.add(dept);
        }
        return depts;
    }

    @Override
    public List<Dept> findByName(String name) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "select deptno,dname,loc from dept where dname like concat('%',?,'%')";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        List<Dept> depts = new ArrayList<Dept>();
        while(rs.next()){
            Dept dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            depts.add(dept);
        }
        return depts;
    }

    @Override
    public Dept findById(Integer id) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select deptno,dname,loc from dept where deptno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Dept dept = null;
        if(rs.next()){
            dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
        }
        return dept;
    }

}
