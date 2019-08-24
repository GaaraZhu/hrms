package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department extends PersistentRoot<Department> {

    private String name;

    private String number;

    private String manager;

    private String telephone;

    public Department() {
    }

    private Department(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.number = builder.number;
        this.manager = builder.manager;
        this.telephone = builder.telephone;
    }

    public String getName() {
        return name;
    }

    public Department name(String name) {
        this.name = name;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Department number(String number) {
        this.number = number;
        return this;
    }

    public String getManager() {
        return manager;
    }

    public Department manager(String manager) {
        this.manager = manager;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Department telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, Department> {
        private String name;
        private String number;
        private String manager;
        private String telephone;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
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
        public Department build() {
            return new Department(this);
        }
    }
}
