package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.domain.entity.common.Gender;

public class CandidateDTO {
    private Long id;
    private String name;
    private Gender gender;
    private String idNumber;
    private String phone;
    private String city;
    private String address;

    public CandidateDTO(){}

    private CandidateDTO(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.gender = builder.gender;
        this.idNumber = builder.idNumber;
        this.phone = builder.phone;
        this.city = builder.city;
        this.address = builder.address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
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

    public static class Builder {
        private Long id;
        private String name;
        private Gender gender;
        private String idNumber;
        private String phone;
        private String city;
        private String address;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder gender(Gender gender) {
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

    public static CandidateDTO map(Candidate c) {
        return new CandidateDTO.Builder()
                .id(c.getId())
                .name(c.getName())
                .gender(c.getGender())
                .idNumber(c.getIdNumber())
                .phone(c.getPhone())
                .city(c.getCity())
                .address(c.getAddress())
                .build();
    }
}
