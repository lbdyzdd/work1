package com.company.dao.factory;

import com.company.dao.impl.DeptDao;
import com.company.dao.impl.EmpDao;
import com.company.dao.impl.UserDao;

public class DaoFactory {

    public static Object getInstance(String name) {
        switch (name) {
            case "EMP":
                return new EmpDao();
            case "DEPT":
                return new DeptDao();
            case "USER":
                return new UserDao();
            default:
                return null;
        }
    }
}

