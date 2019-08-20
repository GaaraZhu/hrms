package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.common.Service;

import java.util.Optional;

public interface UserService extends Service<User> {

    Optional<User> login(String account, String rawPassword);

}
