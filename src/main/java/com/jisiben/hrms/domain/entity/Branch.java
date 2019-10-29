package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch extends PersistentRoot<Branch> {

    private String name;

    private String address;

    private String manager;

    private String telephone;

    public Branch() {
    }

    private Branch(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.address = builder.address;
        this.manager = builder.manager;
        this.telephone = builder.telephone;
    }

    public String getName() {
        return name;
    }

    public Branch name(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Branch address(String address) {
        this.address = address;
        return this;
    }

    public String getManager() {
        return manager;
    }

    public Branch manager(String manager) {
        this.manager = manager;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Branch telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, Branch> {
        private String name;
        private String address;
        private String manager;
        private String telephone;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder manager(String manager) {
            this.manager = manager;
            return this;
        }

        public Builder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        @Override
        public Branch build() {
            return new Branch(this);
        }
    }
}
