package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class JobDTO extends DTORoot<JobDTO>{
    private String company;
    private String city;
    private String name;
    private String salaryRange;
    private String type;
    private int quota;
    private String publisher;
    private String publishedTime;
    private String updater;
    private String updatedTime;
    private boolean referralBonus;
    private int referralBonusAmount;
    private boolean active;

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
        this.publisher=builder.publisher;
        this.publishedTime=builder.publishedTime;
        this.updater=builder.updater;
        this.updatedTime=builder.updatedTime;
        this.referralBonus=builder.referralBonus;
        this.referralBonusAmount=builder.referralBonusAmount;
        this.active=builder.active;
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

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public String getUpdater() {
        return updater;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isReferralBonus() {
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
        private String publisher;
        private String publishedTime;
        private String updater;
        private String updatedTime;
        private boolean referralBonus;
        private int referralBonusAmount;
        private boolean active;

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

        public Builder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder setPublishedTime(String publishedTime) {
            this.publishedTime = publishedTime;
            return this;
        }

        public Builder setUpdater(String updater) {
            this.updater = updater;
            return this;
        }

        public Builder setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
            return this;
        }

        public Builder setReferralBonus(boolean referralBonus) {
            this.referralBonus = referralBonus;
            return this;
        }

        public Builder setReferralBonusAmount(int referralBonusAmount) {
            this.referralBonusAmount = referralBonusAmount;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public JobDTO build() {
            return new JobDTO(this);
        }
    }
}
