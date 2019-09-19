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

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String idNumber;

    private String phone;

    private String ethnicity;

    private String politicalStatus;

    private String degree;

    private String bornAddress;

    private String currentAddress;

    private String bank;

    private String bankAccount;

    private String emergencyContactName;

    private String emergencyContactPhone;

    private String emergencyContactRelationship;

    public Candidate() {
    }

    private Candidate(Builder builder){
        super(builder);
        this.name = builder.name;
        this.gender = builder.gender;
        this.idNumber = builder.idNumber;
        this.phone = builder.phone;
        this.ethnicity=builder.ethnicity;
        this.politicalStatus=builder.politicalStatus;
        this.degree=builder.degree;
        this.bornAddress=builder.bornAddress;
        this.currentAddress=builder.currentAddress;
        this.bank=builder.bank;
        this.bankAccount=builder.bankAccount;
        this.emergencyContactName=builder.emergencyContactName;
        this.emergencyContactPhone=builder.emergencyContactPhone;
        this.emergencyContactRelationship=builder.emergencyContactRelationship;
    }

    public String getName() { return name; }

    public Gender getGender() {
        return gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhone() { return phone; }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public String getDegree() {
        return degree;
    }

    public String getBornAddress() {
        return bornAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getBank() {
        return bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
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

    public Candidate ethnicity(String ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    public Candidate politicalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
        return this;
    }

    public Candidate degree(String degree) {
        this.degree = degree;
        return this;
    }

    public Candidate bornAddress(String bornAddress) {
        this.bornAddress = bornAddress;
        return this;
    }

    public Candidate currentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public Candidate bank(String bank) {
        this.bank = bank;
        return this;
    }

    public Candidate bankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public Candidate emergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
        return this;
    }

    public Candidate emergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
        return this;
    }

    public Candidate emergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, Candidate> {
        private String name;
        private Gender gender;
        private String idNumber;
        private String phone;
        private String ethnicity;
        private String politicalStatus;
        private String degree;
        private String bornAddress;
        private String currentAddress;
        private String bank;
        private String bankAccount;
        private String emergencyContactName;
        private String emergencyContactPhone;
        private String emergencyContactRelationship;

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

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setIdNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEthnicity(String ethnicity) {
            this.ethnicity = ethnicity;
            return this;
        }

        public Builder setPoliticalStatus(String politicalStatus) {
            this.politicalStatus = politicalStatus;
            return this;
        }

        public Builder setDegree(String degree) {
            this.degree = degree;
            return this;
        }

        public Builder setBornAddress(String bornAddress) {
            this.bornAddress = bornAddress;
            return this;
        }

        public Builder setCurrentAddress(String currentAddress) {
            this.currentAddress = currentAddress;
            return this;
        }

        public Builder setBank(String bank) {
            this.bank = bank;
            return this;
        }

        public Builder setBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder setEmergencyContactName(String emergencyContactName) {
            this.emergencyContactName = emergencyContactName;
            return this;
        }

        public Builder setEmergencyContactPhone(String emergencyContactPhone) {
            this.emergencyContactPhone = emergencyContactPhone;
            return this;
        }

        public Builder setEmergencyContactRelationship(String emergencyContactRelationship) {
            this.emergencyContactRelationship = emergencyContactRelationship;
            return this;
        }

        @Override
        public Candidate build() {
            return new Candidate(this);
        }
    }
}
