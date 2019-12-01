package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JobQuota")
public class JobQuota extends PersistentRoot<JobQuota> {

    @ManyToOne(targetEntity=Job.class)
    @JoinColumn(name = "jobId")
    private Job job;

    @ManyToOne(targetEntity=Branch.class)
    @JoinColumn(name = "branchId")
    private Branch branch;

    private String month;

    private Long quota;

    public JobQuota() {
    }

    public JobQuota(Builder builder) {
        this.job=builder.job;
        this.branch=builder.branch;
        this.month=builder.month;
        this.quota=builder.quota;
    }

    public Branch getBranch() {
        return branch;
    }

    public Job getJob() {
        return job;
    }

    public String getMonth() {
        return month;
    }

    public Long getQuota() {
        return quota;
    }

    public JobQuota job(Job job) {
        this.job = job;
        return this;
    }

    public JobQuota month(String month) {
        this.month = month;
        return this;
    }

    public JobQuota quota(Long quota) {
        this.quota = quota;
        return this;
    }

    public JobQuota branch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<JobQuota.Builder, JobQuota> {

        private Job job;
        private String month;
        private Long quota;
        private Branch branch;

        public Builder job(Job job) {
            this.job = job;
            return this;
        }

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder quota(Long quota) {
            this.quota = quota;
            return this;
        }

        public Builder branch(Branch branch) {
            this.branch = branch;
            return this;
        }

        @Override
        public JobQuota build() {
            return new JobQuota(this);
        }
    }
}
