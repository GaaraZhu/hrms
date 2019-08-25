package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class CandidateDTO extends DTORoot<CandidateDTO> {
    private String name;
    private String gender;
    private String idNumber;
    private String phone;
    private String city;
    private String address;

    public CandidateDTO(){}

    private CandidateDTO(Builder builder){
        super(builder);
        this.name = builder.name;
        this.gender = builder.gender;
        this.idNumber = builder.idNumber;
        this.phone = builder.phone;
        this.city = builder.city;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder extends DTORoot.Builder<Builder, CandidateDTO> {
        private String name;
        private String gender;
        private String idNumber;
        private String phone;
        private String city;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder idNumber(String idNumber) {
            this.idNumber = idNumber;
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

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public CandidateDTO build() {
            return new CandidateDTO(this);
        }
    }
}
