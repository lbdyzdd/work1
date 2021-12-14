package com.company.dao.idao;

import com.company.dao.entity.Dept;

import java.util.List;

public interface IDeptDao {
    public int save(Dept dept) throws Exception;
    public int delete(Dept dept)throws Exception;
    public int update(Dept dept)throws Exception;
    public List<Dept> findAll()throws Exception;
    public List<Dept> findByName(String name)throws Exception;
    public Dept findById(Integer id)throws Exception;
}
