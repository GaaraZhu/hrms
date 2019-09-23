package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;
import com.poiji.annotation.ExcelCell;

public class CandidateDTO extends DTORoot<CandidateDTO> {

    @ExcelCell(0)
    private String name;

    @ExcelCell(1)
    private String gender;

    @ExcelCell(2)
    private String idNumber;

    @ExcelCell(3)
    private String phone;

    @ExcelCell(4)
    private String ethnicity;

    @ExcelCell(5)
    private String politicalStatus;

    @ExcelCell(6)
    private String degree;

    @ExcelCell(7)
    private String bornAddress;

    @ExcelCell(8)
    private String currentAddress;

    @ExcelCell(9)
    private String bankAccount;

    @ExcelCell(10)
    private String bank;

    @ExcelCell(11)
    private String emergencyContactName;

    @ExcelCell(12)
    private String emergencyContactPhone;

    @ExcelCell(13)
    private String emergencyContactRelationship;

    public CandidateDTO(){}

    private CandidateDTO(Builder builder){
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

    public static class Builder extends DTORoot.Builder<Builder, CandidateDTO> {
        private String name;
        private String gender;
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

        public Builder ethnicity(String ethnicity) {
            this.ethnicity = ethnicity;
            return this;
        }

        public Builder politicalStatus(String politicalStatus) {
            this.politicalStatus = politicalStatus;
            return this;
        }

        public Builder degree(String degree) {
            this.degree = degree;
            return this;
        }

        public Builder bornAddress(String bornAddress) {
            this.bornAddress = bornAddress;
            return this;
        }

        public Builder currentAddress(String currentAddress) {
            this.currentAddress = currentAddress;
            return this;
        }

        public Builder bank(String bank) {
            this.bank = bank;
            return this;
        }

        public Builder bankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder emergencyContactName(String emergencyContactName) {
            this.emergencyContactName = emergencyContactName;
            return this;
        }

        public Builder emergencyContactPhone(String emergencyContactPhone) {
            this.emergencyContactPhone = emergencyContactPhone;
            return this;
        }

        public Builder emergencyContactRelationship(String emergencyContactRelationship) {
            this.emergencyContactRelationship = emergencyContactRelationship;
            return this;
        }

        public CandidateDTO build() {
            return new CandidateDTO(this);
        }
    }
}
