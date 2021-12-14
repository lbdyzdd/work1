package com.company.service.iservice;

import com.company.dao.entity.Dept;

import java.util.List;

public interface IDeptService {
    public String save(Dept dept);
    public String delete(Dept dept);
    public String update(Dept dept);
    public List<Dept> findAll();
    public List<Dept> findByName(String name);
    public Dept findById(Integer id);
}
