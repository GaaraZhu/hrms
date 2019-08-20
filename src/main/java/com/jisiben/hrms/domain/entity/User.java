package com.jisiben.hrms.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

@Entity
@Table(name = "user")
public class User extends PersistentRoot {

    private static final long serialVersionUID = 3738425611999325473L;

    private String name;

    private String account;

    private String password;

    public User() {
    }

    public User(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.account = builder.account;
        this.password = builder.password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder extends PersistentRoot.Builder<Department.Builder, User> {

        private String name;
        private String account;
        private String password;

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

        @Override
        public User build() {
            return new User(this);
        }
    }
}
