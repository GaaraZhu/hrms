package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class BranchDTO extends DTORoot<BranchDTO> {
    private String name;
    private String address;
    private String manager;
    private String telephone;

    public BranchDTO() {
    }

    private BranchDTO(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.address = builder.address;
        this.manager = builder.manager;
        this.telephone = builder.telephone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getManager() {
        return manager;
    }

    public String getTelephone() {
        return telephone;
    }

    public static class Builder extends DTORoot.Builder<Builder, BranchDTO> {
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

        public BranchDTO build() {
            return new BranchDTO(this);
        }
    }
}
