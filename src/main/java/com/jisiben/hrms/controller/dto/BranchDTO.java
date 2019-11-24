package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class BranchDTO extends DTORoot<BranchDTO> {
    private String name;
    private String company;
    private String city;
    private String district;
    private String address;
    private String manager;
    private String phone;
    private long companyId;

    public BranchDTO() {
    }

    private BranchDTO(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.address = builder.address;
        this.manager = builder.manager;
        this.phone = builder.phone;
        this.district = builder.district;
        this.company = builder.company;
        this.city = builder.city;
        this.companyId = builder.companyId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getDistrict() {
        return district;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getManager() {
        return manager;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder extends DTORoot.Builder<Builder, BranchDTO> {
        private String name;
        private String address;
        private String manager;
        private String phone;
        private String district;
        private String company;
        private String city;
        private long companyId;

        public Builder companyId(long companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
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

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public BranchDTO build() {
            return new BranchDTO(this);
        }
    }
}
