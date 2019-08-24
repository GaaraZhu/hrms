package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.Gender;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate extends PersistentRoot<Candidate> {
    private static final long serialVersionUID = 3518845612990325404L;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String idNumber;

    private String phone;

    private String city;

    private String address;

    public Candidate() {
    }

    private Candidate(Builder builder){
        super(builder);
        this.name = builder.name;
        this.gender = builder.gender;
        this.idNumber = builder.idNumber;
        this.phone = builder.phone;
        this.city = builder.city;
        this.address = builder.address;
    }

    public String getName() { return name; }

    public Gender getGender() {
        return gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhone() { return phone; }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Candidate name(String name) {
        this.name = name;
        return this;
    }

    public Candidate gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Candidate idNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public Candidate phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Candidate city(String city) {
        this.city = city;
        return this;
    }

    public Candidate address(String address) {
        this.address = address;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, Candidate> {
        private String name;
        private Gender gender;
        private String idNumber;
        private String phone;
        private String city;
        private String address;

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

        @Override
        public Candidate build() {
            return new Candidate(this);
        }
    }
}
