package com.company.service.impl;

import com.company.comm.Const;
import com.company.dao.entity.User;
import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IUserDao;
import com.company.service.iservice.IUserService;

public class UserService implements IUserService {
    IUserDao userDao;

    public UserService() {
        userDao = (IUserDao) DaoFactory.getInstance(Const.USER);
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            user = userDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
