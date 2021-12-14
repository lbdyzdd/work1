package com.company.test;


import com.company.comm.Const;
import com.company.dao.entity.User;
import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IUserDao;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

    IUserDao userDao;
    @Before
    public void init(){
        userDao = (IUserDao) DaoFactory.getInstance(Const.USER);
    }
    @Test
    public void findById() throws Exception {
        User u1 = userDao.findById(1);
        System.out.println(u1);
        User u2 = userDao.findById(111);
        System.out.println(u2);
    }
}