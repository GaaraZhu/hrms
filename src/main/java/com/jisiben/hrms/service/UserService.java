package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.common.Service;

import java.util.List;

public interface UserService extends Service<User> {
    void updatePassword(String account, String password);

    User findByAccount(String account);

    List<User> findByAuthority(int authority);
}
