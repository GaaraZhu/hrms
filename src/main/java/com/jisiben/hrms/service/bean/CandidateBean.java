package com.jisiben.hrms.service.bean;

import com.poiji.annotation.ExcelCell;

public class CandidateBean {

    @ExcelCell(0)
    private String name;

    @ExcelCell(1)
    private String gender;

    @ExcelCell(2)
    private String ethnicity;

    @ExcelCell(3)
    private String idNumber;

    @ExcelCell(4)
    private String politicalStatus;

    @ExcelCell(5)
    private String degree;

    @ExcelCell(6)
    private String phone;

    @ExcelCell(7)
    private String bornAddress;

    @ExcelCell(8)
    private String currentAddress;

    @ExcelCell(9)
    private String bank;

    @ExcelCell(10)
    private String bankAccount;

    @ExcelCell(11)
    private String emergencyContactName;

    @ExcelCell(12)
    private String emergencyContactPhone;

    @ExcelCell(13)
    private String emergencyContactRelationship;

    public String getName() {
        return name;
    }

    public CandidateBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public CandidateBean setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public CandidateBean setIdNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CandidateBean setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public CandidateBean setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public CandidateBean setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
        return this;
    }

    public String getDegree() {
        return degree;
    }

    public CandidateBean setDegree(String degree) {
        this.degree = degree;
        return this;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public CandidateBean setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
        return this;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public CandidateBean setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
        return this;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    public CandidateBean setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
        return this;
    }

    public String getBornAddress() {
        return bornAddress;
    }

    public CandidateBean setBornAddress(String bornAddress) {
        this.bornAddress = bornAddress;
        return this;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public CandidateBean setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public String getBank() {
        return bank;
    }

    public CandidateBean setBank(String bank) {
        this.bank = bank;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public CandidateBean setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Candidate: name=%s, gender=%s, idNumber=%s, phone=%s, bornAddress=%s, currentAddress=%s",
                name, gender, idNumber, phone, bornAddress, currentAddress);
    }
}
