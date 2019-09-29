package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "JobApplication")
public class JobApplication extends PersistentRoot<JobApplication> {

    private Job job;

    private Candidate candidate;

    private String referee;

    private String refereePhone;

    private Date applicationDate;

    private JobApplicationStatus status;

    private Date onBoardedOrResignedDate;

    public JobApplication() {
    }

    public JobApplication(JobApplication.Builder builder) {
        super(builder);
        this.job=builder.job;
        this.candidate=builder.candidate;
        this.referee=builder.referee;
        this.refereePhone=builder.refereePhone;
        this.applicationDate=builder.applicationDate;
        this.status=builder.status;
        this.onBoardedOrResignedDate=builder.onBoardedOrResignedDate;
    }

    public Job getJob() {
        return job;
    }

    public JobApplication job(Job job) {
        this.job = job;
        return this;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public JobApplication candidate(Candidate candidate) {
        this.candidate = candidate;
        return this;
    }

    public String getReferee() {
        return referee;
    }

    public JobApplication referee(String referee) {
        this.referee = referee;
        return this;
    }

    public String getRefereePhone() {
        return refereePhone;
    }

    public JobApplication refereePhone(String refereePhone) {
        this.refereePhone = refereePhone;
        return this;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public JobApplication applicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
        return this;
    }

    public JobApplicationStatus getStatus() {
        return status;
    }

    public JobApplication status(JobApplicationStatus status) {
        this.status = status;
        return this;
    }

    public Date getOnBoardedOrResignedDate() {
        return onBoardedOrResignedDate;
    }

    public JobApplication onBoardedOrResignedDate(Date onBoardedOrResignedDate) {
        this.onBoardedOrResignedDate = onBoardedOrResignedDate;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<JobApplication.Builder, JobApplication> {

        private Job job;
        private Candidate candidate;
        private String referee;
        private String refereePhone;
        private Date applicationDate;
        private JobApplicationStatus status;
        private Date onBoardedOrResignedDate;

        public Builder job(Job job) {
            this.job = job;
            return this;
        }

        public Builder candidate(Candidate candidate) {
            this.candidate = candidate;
            return this;
        }

        public Builder referee(String referee) {
            this.referee = referee;
            return this;
        }

        public Builder refereePhone(String refereePhone) {
            this.refereePhone = refereePhone;
            return this;
        }

        public Builder applicationDate(Date applicationDate) {
            this.applicationDate = applicationDate;
            return this;
        }

        public Builder status(JobApplicationStatus status) {
            this.status = status;
            return this;
        }

        public Builder onBoardedOrResignedDate(Date onBoardedOrResignedDate) {
            this.onBoardedOrResignedDate = onBoardedOrResignedDate;
            return this;
        }

        @Override
        public JobApplication build() {
            return new JobApplication(this);
        }
    }
}
