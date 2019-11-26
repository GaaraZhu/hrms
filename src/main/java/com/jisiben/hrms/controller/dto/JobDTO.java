package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class JobDTO extends DTORoot<JobDTO>{
    private String company;
    private String city;
    private String address;
    private String name;
    private String salaryRange;
    private String type;
    private String referralBonus;
    private int referralBonusAmount;
    private String active;
    private String note;
    private long companyId;

    public JobDTO() {
    }

    private JobDTO(Builder builder) {
        super(builder);
        this.company=builder.company;
        this.city=builder.city;
        this.address=builder.address;
        this.name=builder.name;
        this.salaryRange=builder.salaryRange;
        this.type=builder.type;
        this.referralBonus=builder.referralBonus;
        this.referralBonusAmount=builder.referralBonusAmount;
        this.active=builder.active;
        this.note=builder.note;
        this.companyId=builder.companyId;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public String getType() {
        return type;
    }

    public String getActive() {
        return active;
    }

    public String getNote() { return note; }

    public String getReferralBonus() {
        return referralBonus;
    }

    public int getReferralBonusAmount() {
        return referralBonusAmount;
    }

    public String getAddress() {
        return address;
    }

    public long getCompanyId() {
        return companyId;
    }

    public static class Builder extends DTORoot.Builder<Builder, JobDTO> {
        private String company;
        private String city;
        private String address;
        private String name;
        private String salaryRange;
        private String type;
        private String referralBonus;
        private int referralBonusAmount;
        private String active;
        private String note;
        private long companyId;

        public Builder(){}

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder salaryRange(String salaryRange) {
            this.salaryRange = salaryRange;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder referralBonus(String referralBonus) {
            this.referralBonus = referralBonus;
            return this;
        }

        public Builder companyId(long companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder referralBonusAmount(int referralBonusAmount) {
            this.referralBonusAmount = referralBonusAmount;
            return this;
        }

        public Builder active(String active) {
            this.active = active;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public JobDTO build() {
            return new JobDTO(this);
        }
    }
}
