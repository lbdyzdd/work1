package com.company.service.impl;

import com.company.comm.Const;
import com.company.dao.entity.User;
import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IUserDao;
import com.company.service.iservice.ILoginService;

public class LoginService implements ILoginService {
    IUserDao userDao;
    public LoginService() {
        userDao = (IUserDao) DaoFactory.getInstance(Const.USER);
    }
    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            user = userDao.login(username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
