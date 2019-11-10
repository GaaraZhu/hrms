package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    protected Dao<User, Long> getDao() {
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
        String name = criteria.get("name").map(Object::toString).orElse(null);
        String account = criteria.get("account").map(Object::toString).orElse(null);
        Integer authority = criteria.get("authority").map(Integer.class::cast).orElse(null);
        return userDao.findByAccountAndNameAndAuthority(account, name, authority, new PageRequest(currentPage-1, pageSize));
    }

    @Override
    public User findByAccount(String account) {
        return userDao.findByAccount(account);
    }
}