package com.company.dao.idao;

import com.company.controller.vo.EmpVO;
import com.company.dao.entity.Emp;

import java.util.List;

public interface IEmpDao {
    public int save(Emp emp) throws Exception;
    public int delete(Emp emp)throws Exception;
    public int update(Emp emp)throws Exception;
    public List<Emp> findByPage(int begin, int size)throws Exception;
    public List<Emp> findByName(String name)throws Exception;
    public Emp findById(Integer id)throws Exception;
    //作业
    public List<Emp> findByDynamicSQL(EmpVO empVO)throws Exception;

    List<Emp> findAll()throws Exception;
}
