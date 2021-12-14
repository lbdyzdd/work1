package com.company.service.impl;

import com.company.comm.Const;
import com.company.controller.vo.EmpVO;
import com.company.dao.entity.Emp;
import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IEmpDao;
import com.company.service.iservice.IEmpService;

import java.util.List;

public class EmpService implements IEmpService {
    private IEmpDao empDao;

    public EmpService() {
        empDao = (IEmpDao) DaoFactory.getInstance(Const.EMP);
    }

    @Override
    public String save(Emp emp) {
        //TODO:权限判断
        //TODO:如果emp表中有unique约束的字段，例如身份证号码ID，就需要根据ID进行查询，判断emp对象是否已经存在
        String msg = Const.ERROR;
        try {
            int flag = empDao.save(emp);
            if(flag == 1){
                msg = Const.SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String delete(Emp emp) {
        String msg = Const.ERROR;
        try {
            int flag = empDao.delete(emp);
            if(flag == 1){
                msg = Const.SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String update(Emp emp) {
        String msg = Const.ERROR;
        try {
            int flag = empDao.update(emp);
            if(flag == 1){
                msg = Const.SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public List<Emp> findByPage(Integer page,Integer size) {
        List<Emp> emps = null;
        if(page == null) page = 1;
        if(size == null) size = 10;
        int begin = (page-1)*size;
        try {
            emps = empDao.findByPage(begin,size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public List<Emp> findByName(String name) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Emp findById(Integer id) {
        Emp emp = null;
        try {
            emp = empDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public List<Emp> findByDynamicSQL(EmpVO empVO) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByDynamicSQL(empVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public List<Emp> findAll() {
        List<Emp> emps = null;
        try {
            emps = empDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }
}
