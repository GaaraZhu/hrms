package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserDao extends Dao<User, Long> {

    User save(User user);

    User findByAccount(String account);

    @Modifying
    @Transactional
    @Query(value = "update User u set u.password = :password where u.account = :account")
    void updatePassword(@Param("account")String account, @Param("password")String password);
}