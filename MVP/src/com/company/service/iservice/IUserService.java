package com.company.service.iservice;

import com.company.dao.entity.User;

public interface IUserService {
    User findById(int id);
}
