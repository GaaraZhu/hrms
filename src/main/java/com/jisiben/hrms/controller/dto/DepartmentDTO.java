package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.domain.entity.Department;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String number;
    private String manager;
    private String telephone;

    public DepartmentDTO() {
    }

    private DepartmentDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.number = builder.number;
        this.manager = builder.manager;
        this.telephone = builder.telephone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getManager() {
        return manager;
    }

    public String getTelephone() {
        return telephone;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String number;
        private String manager;
        private String telephone;

        public Builder(){}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

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

        public DepartmentDTO build() {
            return new DepartmentDTO(this);
        }
    }
}
