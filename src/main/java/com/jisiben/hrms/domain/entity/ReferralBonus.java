package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import com.jisiben.hrms.domain.entity.common.ReferralBonusStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ReferralBonus")
public class ReferralBonus extends PersistentRoot<ReferralBonus> {

    @OneToOne(targetEntity=JobApplication.class)
    @JoinColumn(name = "applicationId")
    private JobApplication application;

    @Enumerated(EnumType.STRING)
    private ReferralBonusStatus status;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date approvedDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date transferredDate;

    public ReferralBonus() {
    }

    public ReferralBonus(Builder builder) {
        super(builder);
        this.application = builder.application;
        this.status = builder.status;
        this.approvedDate = builder.approvedDate;
        this.transferredDate = builder.transferredDate;
    }

    public JobApplication getApplication() {
        return application;
    }

    public ReferralBonus application(JobApplication application) {
        this.application = application;
        return this;
    }

    public ReferralBonusStatus getStatus() {
        return status;
    }

    public ReferralBonus status(ReferralBonusStatus status) {
        this.status = status;
        return this;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public ReferralBonus approvedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
        return this;
    }

    public Date getTransferredDate() {
        return transferredDate;
    }

    public ReferralBonus transferredDate(Date transferredDate) {
        this.transferredDate = transferredDate;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<ReferralBonus.Builder, ReferralBonus> {
        private JobApplication application;
        private ReferralBonusStatus status;
        private Date approvedDate;
        private Date transferredDate;

        public Builder application(JobApplication application) {
            this.application = application;
            return this;
        }

        public Builder status(ReferralBonusStatus status) {
            this.status = status;
            return this;
        }

        public Builder approvedDate(Date approvedDate) {
            this.approvedDate = approvedDate;
            return this;
        }

        public Builder transferredDate(Date transferredDate) {
            this.transferredDate = transferredDate;
            return this;
        }

        @Override
        public ReferralBonus build() {
            return new ReferralBonus(this);
        }
    }
}
