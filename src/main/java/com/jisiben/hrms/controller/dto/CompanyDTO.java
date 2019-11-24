package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class CompanyDTO extends DTORoot<CompanyDTO> {
    private String name;
    private String city;
    private String address;
    private String phone;
    private int branchCount;

    public CompanyDTO() {
    }

    private CompanyDTO(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.city = builder.city;
        this.address = builder.address;
        this.phone = builder.phone;
        this.branchCount = builder.branchCount;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getBranchCount() {
        return branchCount;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder extends DTORoot.Builder<Builder, CompanyDTO> {
        private String name;
        private String city;
        private String address;
        private String phone;
        private int branchCount;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder branchCount(int branchCount) {
            this.branchCount = branchCount;
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

        public CompanyDTO build() {
            return new CompanyDTO(this);
        }
    }
}
