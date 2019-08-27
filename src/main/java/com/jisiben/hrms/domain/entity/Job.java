package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.JobType;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job extends PersistentRoot<Job> {

    private String company;

    private String city;

    private String name;

    private String salaryRange;

    private JobType type;

    private int quota;

    private boolean referralBonus;

    private int referralBonusAmount;

    private boolean active;

    private String note;

    public Job() {
    }

    private Job(Builder builder){
        super(builder);
        this.company=builder.company;
        this.city=builder.city;
        this.name=builder.name;
        this.salaryRange=builder.salaryRange;
        this.type=builder.type;
        this.quota=builder.quota;
        this.referralBonus=builder.referralBonus;
        this.referralBonusAmount=builder.referralBonusAmount;
        this.note=builder.note;
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

    public JobType getType() {
        return type;
    }

    public int getQuota() {
        return quota;
    }

    public boolean isReferralBonus() {
        return referralBonus;
    }

    public int getReferralBonusAmount() {
        return referralBonusAmount;
    }

    public boolean isActive() {
        return active;
    }

    public String getNote() {
        return note;
    }

    public Job company(String company) {
        this.company = company;
        return this;
    }

    public Job city(String city) {
        this.city = city;
        return this;
    }

    public Job name(String name) {
        this.name = name;
        return this;
    }

    public Job type(JobType type) {
        this.type = type;
        return this;
    }

    public Job salaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
        return this;
    }

    public Job quota(int quota) {
        this.quota = quota;
        return this;
    }

    public Job referralBonus(boolean referralBonus) {
        this.referralBonus = referralBonus;
        return this;
    }

    public Job referralBonusAmount(int referralBonusAmount) {
        this.referralBonusAmount = referralBonusAmount;
        return this;
    }

    public Job active(boolean active) {
        this.active = active;
        return this;
    }

    public Job note(String note) {
        this.note = note;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, Job> {
        private String company;
        private String city;
        private String name;
        private String salaryRange;
        private JobType type;
        private int quota;
        private boolean referralBonus;
        private int referralBonusAmount;
        private String note;
        private boolean active;

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

        public Builder type(JobType type) {
            this.type = type;
            return this;
        }

        public Builder quota(int quota) {
            this.quota = quota;
            return this;
        }

        public Builder referralBonus(boolean referralBonus) {
            this.referralBonus = referralBonus;
            return this;
        }

        public Builder referralBonusAmount(int referralBonusAmount) {
            this.referralBonusAmount = referralBonusAmount;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        @Override
        public Job build() {
            return new Job(this);
        }
    }
}
