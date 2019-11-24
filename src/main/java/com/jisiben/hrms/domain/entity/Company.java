package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company extends PersistentRoot<Company> {
    private String name;
    private String city;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches;

    public Company() {
    }

    public Company(Builder builder) {
        super(builder);
        this.name=builder.name;
        this.city=builder.city;
        this.address=builder.address;
        this.phone=builder.phone;
        this.branches=builder.branches;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public Company name(String name) {
        this.name = name;
        return this;
    }

    public Company city(String city) {
        this.city = city;
        return this;
    }

    public Company address(String address) {
        this.address = address;
        return this;
    }

    public Company phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Company branches(List<Branch> branches) {
        this.branches = branches;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Company.Builder, Company> {
        private String name;
        private String city;
        private String address;
        private String phone;
        private List<Branch> branches;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder branches(List<Branch> branches) {
            this.branches = branches;
            return this;
        }

        @Override
        public Company build() {
            return new Company(this);
        }
    }
}
