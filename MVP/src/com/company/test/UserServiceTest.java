package com.company.test;

import com.company.comm.Const;
import com.company.dao.entity.User;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IUserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    IUserService userService;
    @Before
    public void setUp(){
        userService = (IUserService) ServiceFactory.getInstance(Const.USER);
    }

    @Test
    public void findById() {
        User u1 = userService.findById(1);
        User u2 = userService.findById(1111);
        System.out.println(u1);
        System.out.println(u2);

    }
}