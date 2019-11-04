package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @Query("FROM User u WHERE (:account is null or u.account = :account) and (:name is null"
            + " or u.name = :name) and (:authority is null or u.authority = :authority)")
    Page<User> findByAccountAndNameAndAuthority(
            @Param("account")String account,
            @Param("name")String name,
            @Param("authority")Integer authority,
            Pageable pageable);
}