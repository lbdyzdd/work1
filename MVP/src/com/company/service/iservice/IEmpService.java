package com.company.service.iservice;

import com.company.controller.vo.EmpVO;
import com.company.dao.entity.Emp;

import java.util.List;

public interface IEmpService {
    public String save(Emp emp) ;
    public String delete(Emp emp);
    public String update(Emp emp);
    public List<Emp> findByPage(Integer page, Integer size);
    public List<Emp> findByName(String name);
    public Emp findById(Integer id);
    //动态查询
    public List<Emp> findByDynamicSQL(EmpVO empVO);

    List<Emp> findAll();
}
