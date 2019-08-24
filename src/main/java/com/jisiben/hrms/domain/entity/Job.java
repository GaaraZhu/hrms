package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.JobType;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import com.jisiben.hrms.domain.entity.common.ReferralBonusCondition;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
public class Job extends PersistentRoot {
    private static final long serialVersionUID = 1568877619990325404L;

    private String company;

    private String city;

    private String name;

    private String salaryRange;

    private JobType type;

    private int quota;

    private boolean referralBonus;

    private int referralBonusAmount;

    private boolean active;

    @Enumerated(EnumType.STRING)
    private ReferralBonusCondition bonusCondition;

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
        this.bonusCondition=builder.bonusCondition;
        this.note=builder.note;
        this.active=builder.active;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompany() {
        return company;
    }

    public Job setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Job setCity(String city) {
        this.city = city;
        return this;
    }

    public String getName() {
        return name;
    }

    public Job setName(String name) {
        this.name = name;
        return this;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public Job setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
        return this;
    }

    public JobType getType() {
        return type;
    }

    public Job setType(JobType type) {
        this.type = type;
        return this;
    }

    public int getQuota() {
        return quota;
    }

    public Job setQuota(int quota) {
        this.quota = quota;
        return this;
    }

    public boolean isReferralBonus() {
        return referralBonus;
    }

    public Job setReferralBonus(boolean referralBonus) {
        this.referralBonus = referralBonus;
        return this;
    }

    public int getReferralBonusAmount() {
        return referralBonusAmount;
    }

    public Job setReferralBonusAmount(int referralBonusAmount) {
        this.referralBonusAmount = referralBonusAmount;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Job setActive(boolean active) {
        this.active = active;
        return this;
    }

    public ReferralBonusCondition getBonusCondition() {
        return bonusCondition;
    }

    public Job setBonusCondition(ReferralBonusCondition bonusCondition) {
        this.bonusCondition = bonusCondition;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Job setNote(String note) {
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
        private ReferralBonusCondition bonusCondition;
        private String note;
        private boolean active;

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

        public Builder setType(JobType type) {
            this.type = type;
            return this;
        }

        public Builder setQuota(int quota) {
            this.quota = quota;
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

        public Builder setBonusCondition(ReferralBonusCondition bonusCondition) {
            this.bonusCondition = bonusCondition;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }

        @Override
        public Job build() {
            return new Job(this);
        }
    }
}
