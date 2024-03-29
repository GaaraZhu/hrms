package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.JobType;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.*;

@Entity
@Table(name = "Job")
public class Job extends PersistentRoot<Job> {

    @ManyToOne(targetEntity=Company.class)
    @JoinColumn(name = "companyId")
    private Company company;

    private String name;

    private String salaryRange;

    @Enumerated(EnumType.STRING)
    private JobType type;

    private boolean referralBonus;

    private int referralBonusAmount;

    private boolean active;

    private String note;

    public Job() {
    }

    private Job(Builder builder){
        super(builder);
        this.company=builder.company;
        this.name=builder.name;
        this.salaryRange=builder.salaryRange;
        this.type=builder.type;
        this.referralBonus=builder.referralBonus;
        this.referralBonusAmount=builder.referralBonusAmount;
        this.note=builder.note;
        this.active=builder.active;
    }

    public Company getCompany() {
        return company;
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

    public Job company(Company company) {
        this.company = company;
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
        private Company company;
        private String name;
        private String salaryRange;
        private JobType type;
        private boolean referralBonus;
        private int referralBonusAmount;
        private String note;
        private boolean active;

        public Builder company(Company company) {
            this.company = company;
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
