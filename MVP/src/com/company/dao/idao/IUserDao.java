package com.company.dao.idao;

import com.company.dao.entity.User;

public interface IUserDao {
    User login(String username, String password)throws Exception;
    User findById(int id)throws Exception;
}
