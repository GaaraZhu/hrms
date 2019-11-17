package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JobTargetQuota")
public class JobQuota extends PersistentRoot<JobQuota> {

    @ManyToOne(targetEntity=Job.class)
    @JoinColumn(name = "jobId")
    private Job job;

    private String month;

    private int quota;

    public JobQuota() {
    }

    public JobQuota(Builder builder) {
        this.job=builder.job;
        this.month=builder.month;
        this.quota=builder.quota;
    }

    public static class Builder extends PersistentRoot.Builder<JobQuota.Builder, JobQuota> {

        private Job job;
        private String month;
        private int quota;

        public Builder setJob(Job job) {
            this.job = job;
            return this;
        }

        public Builder setMonth(String month) {
            this.month = month;
            return this;
        }

        public Builder setQuota(int quota) {
            this.quota = quota;
            return this;
        }

        @Override
        public JobQuota build() {
            return new JobQuota(this);
        }
    }
}
