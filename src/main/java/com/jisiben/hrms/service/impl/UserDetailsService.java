package com.jisiben.hrms.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.jisiben.hrms.domain.dao.UserDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserDao userDao;

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            com.jisiben.hrms.domain.entity.User user = getUserDao().findByAccount(username);
            userDetails = new User(username, user.getPassword(), getAuthorities(user.getAuthority()));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        return userDetails;
    }

    private Collection<GrantedAuthority> getAuthorities(Integer access) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (access == 1) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return authorities;
    }

    protected UserDao getUserDao() {
        return userDao;
    }
}
