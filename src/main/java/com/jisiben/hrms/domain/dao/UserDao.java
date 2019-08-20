package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.User;

public interface UserDao extends Dao<User, Long> {

    User save(User user);

    User findByAccount(String account);

}