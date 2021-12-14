package com.company.service.factory;

import com.company.dao.impl.DeptDao;
import com.company.dao.impl.EmpDao;
import com.company.service.impl.DeptService;
import com.company.service.impl.EmpService;
import com.company.service.impl.LoginService;
import com.company.service.impl.UserService;

public class ServiceFactory {

    public static Object getInstance(String name) {
        switch (name) {
            case "EMP":
                return new EmpService();
            case "DEPT":
                return new DeptService();
            case "LOGIN":
                return new LoginService();
            case "USER":
                return new UserService();
            default:
                return null;
        }
    }
}

