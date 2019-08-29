package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class JobDTO extends DTORoot<JobDTO>{
    private String company;
    private String city;
    private String name;
    private String salaryRange;
    private String type;
    private int quota;
    private String referralBonus;
    private int referralBonusAmount;
    private String active;
    private String note;

    public JobDTO() {
    }

    private JobDTO(Builder builder) {
        super(builder);
        this.company=builder.company;
        this.city=builder.city;
        this.name=builder.name;
        this.salaryRange=builder.salaryRange;
        this.type=builder.type;
        this.quota=builder.quota;
        this.referralBonus=builder.referralBonus;
        this.referralBonusAmount=builder.referralBonusAmount;
        this.active=builder.active;
        this.note=builder.note;
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

    public int getQuota() {
        return quota;
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

    public static class Builder extends DTORoot.Builder<Builder, JobDTO> {
        private String company;
        private String city;
        private String name;
        private String salaryRange;
        private String type;
        private int quota;
        private String referralBonus;
        private int referralBonusAmount;
        private String active;
        private String note;

        public Builder(){}

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSalaryRange(String salaryRange) {
            this.salaryRange = salaryRange;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setQuota(int quota) {
            this.quota = quota;
            return this;
        }

        public Builder setReferralBonus(String referralBonus) {
            this.referralBonus = referralBonus;
            return this;
        }

        public Builder setReferralBonusAmount(int referralBonusAmount) {
            this.referralBonusAmount = referralBonusAmount;
            return this;
        }

        public Builder setActive(String active) {
            this.active = active;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public JobDTO build() {
            return new JobDTO(this);
        }
    }
}
