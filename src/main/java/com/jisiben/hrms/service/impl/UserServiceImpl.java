package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import com.jisiben.hrms.util.EncryptUtil;
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

    public Optional<User> login(String account, String rawPassword) {
        User d = getUserDao().findByAccount(account);
        return Optional.ofNullable(getUserDao().findByAccount(account))
                .filter((User user)-> EncryptUtil.match(rawPassword, user.getPassword()));
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Page<User> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        return null;
    }
}