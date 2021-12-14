package com.company.service.impl;

import com.company.comm.Const;
import com.company.dao.entity.Dept;
import com.company.dao.entity.Emp;
import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IDeptDao;
import com.company.service.iservice.IDeptService;

import java.util.List;

public class DeptService implements IDeptService {
    private IDeptDao deptDao;

    public DeptService() {
        deptDao = (IDeptDao) DaoFactory.getInstance(Const.DEPT);
    }

    @Override
    public String save(Dept dept) {
        String msg = Const.ERROR;
        try {
            int flag = deptDao.save(dept);
            if(flag == 1){
                msg = Const.SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String delete(Dept dept) {
        String msg = Const.ERROR;
        try {
            int flag = deptDao.delete(dept);
            if(flag == 1){
                msg = Const.SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String update(Dept dept) {
        String msg = Const.ERROR;
        try {
            int flag = deptDao.update(dept);
            if(flag == 1){
                msg = Const.SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public List<Dept> findAll() {
        List<Dept> depts = null;
        try {
            depts = deptDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return depts;
    }

    @Override
    public List<Dept> findByName(String name) {
        List<Dept> depts = null;
        try {
            depts = deptDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return depts;
    }

    @Override
    public Dept findById(Integer id) {
        Dept dept = null;
        try {
            dept = deptDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dept;
    }
}
