package com.jisiben.hrms.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.UserService;
import com.jisiben.hrms.service.impl.UserDetailsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableJpaRepositories(basePackages="com.jisiben.hrms.domain.dao")
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@ComponentScan(value = "com.jisiben.hrms.service.impl")
public class Configurations {

    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @Autowired
    private UserService userService;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        return mapper;
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return ()->SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Bean
    public Md5PasswordEncoder md5PasswordEncoder() {
        return new Md5PasswordEncoder();
    }

    @Bean
    @Autowired
    public DaoAuthenticationProvider daoAuthenticationProvider(
            UserDetailsService userDetailService,
            Md5PasswordEncoder md5PasswordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(md5PasswordEncoder);
        provider.setUserDetailsService(userDetailService);
        provider.setSaltSource(new SaltSource() {
            @Override
            public Object getSalt(UserDetails userDetails) {
                return userDetails.getUsername();
            }
        });
        return provider;
    }
}
