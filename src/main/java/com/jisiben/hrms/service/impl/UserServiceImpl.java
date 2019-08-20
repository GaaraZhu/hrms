package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import com.jisiben.hrms.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserDao userDao;

    @Override
    public Dao<User, Long> getDao() {
        return userDao;
    }

    public Optional<User> login(String account, String rawPassword) {
        logger.info("rawpassword: " + rawPassword);
        User d = getUserDao().findByAccount(account);
        if (d!=null) {
            logger.info("savedPassword: " + d.getPassword());
            logger.info("is equal: " + EncryptUtil.match(rawPassword, d.getPassword()));
        }
        return Optional.ofNullable(getUserDao().findByAccount(account))
                .filter((User user)-> EncryptUtil.match(rawPassword, user.getPassword()));
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}