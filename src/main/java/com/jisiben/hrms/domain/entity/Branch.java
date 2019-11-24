package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch extends PersistentRoot<Branch> {

    private String name;

    private String district;

    private String address;

    private String manager;

    private String phone;

    @ManyToOne(targetEntity=Company.class)
    @JoinColumn(name = "companyId")
    private Company company;

    public Branch() {
    }

    private Branch(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.district = builder.district;
        this.address = builder.address;
        this.manager = builder.manager;
        this.phone = builder.phone;
        this.company = builder.company;
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

    public Branch district(String district) {
        this.district = district;
        return this;
    }

    public String getManager() {
        return manager;
    }

    public Branch manager(String manager) {
        this.manager = manager;
        return this;
    }

    public Branch company(Company company) {
        this.company = company;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Branch phone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Company getCompany() {
        return company;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, Branch> {
        private String name;
        private String district;
        private String address;
        private String manager;
        private String phone;
        private Company company;

        public Builder company(Company company) {
            this.company = company;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

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

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        @Override
        public Branch build() {
            return new Branch(this);
        }
    }
}
