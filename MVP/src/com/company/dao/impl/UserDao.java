package com.company.dao.impl;

import com.company.dao.entity.User;
import com.company.dao.idao.IUserDao;
import com.company.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao implements IUserDao {
    @Override
    public User login(String username, String password) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select username,password,pri from tuser where username=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User(rs.getString(1),rs.getString(2),rs.getInt(3));
        }
        return user;
    }

    @Override
    public User findById(int id) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select id,username,password,pri from tuser where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        //将结果集封装成User对象
        User user = null;
        if(rs.next()){
            user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
        }
        DBUtil.close(rs,ps,con);
        return user;
    }
}
