package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Dao<User, Long> getDao() {
        return userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updatePassword(String account, String password) {
        userDao.updatePassword(account, password);
    }

    @Override
    public Page<User> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        return null;
    }
}