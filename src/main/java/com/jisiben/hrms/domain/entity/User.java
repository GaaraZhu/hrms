package com.jisiben.hrms.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

@Entity
@Table(name = "user")
public class User extends PersistentRoot<User> {

    private String name;

    private String account;

    private String password;

    private Integer authority;

    public User() {
    }

    public User(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.account = builder.account;
        this.password = builder.password;
        this.authority = builder.authority;
    }

    public String getName() {
        return name;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User account(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public Integer getAuthority() {
        return authority;
    }

    public User authority(Integer authority) {
        this.authority = authority;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Department.Builder, User> {

        private String name;
        private String account;
        private String password;
        private Integer authority;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder account(String account) {
            this.account = account;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder authority(Integer authority) {
            this.authority = authority;
            return this;
        }

        @Override
        public User build() {
            return new User(this);
        }
    }
}
