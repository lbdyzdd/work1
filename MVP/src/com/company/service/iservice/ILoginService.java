package com.company.service.iservice;

import com.company.dao.entity.User;

public interface ILoginService {
    User login(String username, String password);
}
