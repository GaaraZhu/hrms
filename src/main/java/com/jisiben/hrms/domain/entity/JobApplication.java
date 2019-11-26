package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jobApplication")
public class JobApplication extends PersistentRoot<JobApplication> {

    @ManyToOne(targetEntity=Job.class)
    @JoinColumn(name = "jobId")
    private Job job;

    @ManyToOne(targetEntity=Candidate.class)
    @JoinColumn(name = "candidateId")
    private Candidate candidate;

    @ManyToOne(targetEntity=Branch.class)
    @JoinColumn(name = "branchId")
    private Branch branch;

    private String referee;

    private String refereePhone;

    @Enumerated(EnumType.STRING)
    private JobApplicationStatus status;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date applicationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date interviewDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date onboardDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date resignDate;

    public JobApplication() {
    }

    public JobApplication(JobApplication.Builder builder) {
        super(builder);
        this.job=builder.job;
        this.candidate=builder.candidate;
        this.referee=builder.referee;
        this.branch=builder.branch;
        this.refereePhone=builder.refereePhone;
        this.status=builder.status;
        this.applicationDate=builder.applicationDate;
        this.interviewDate=builder.interviewDate;
        this.onboardDate=builder.onboardDate;
        this.resignDate=builder.resignDate;
    }

    public Job getJob() {
        return job;
    }

    public JobApplication job(Job job) {
        this.job = job;
        return this;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public JobApplication interviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
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

    public Branch getBranch() {
        return branch;
    }

    public JobApplication branch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public JobApplicationStatus getStatus() {
        return status;
    }

    public JobApplication status(JobApplicationStatus status) {
        this.status = status;
        return this;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public JobApplication applicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
        return this;
    }

    public Date getOnboardDate() {
        return onboardDate;
    }

    public JobApplication onboardDate(Date onboardDate) {
        this.onboardDate = onboardDate;
        return this;
    }

    public Date getResignDate() {
        return resignDate;
    }

    public JobApplication resignDate(Date resignDate) {
        this.resignDate = resignDate;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<JobApplication.Builder, JobApplication> {

        private Job job;
        private Candidate candidate;
        private Branch branch;
        private String referee;
        private String refereePhone;
        private JobApplicationStatus status;
        private Date applicationDate;
        private Date interviewDate;
        private Date onboardDate;
        private Date resignDate;

        public Builder job(Job job) {
            this.job = job;
            return this;
        }

        public Builder setBranch(Branch branch) {
            this.branch = branch;
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

        public Builder onboardDate(Date onboardDate) {
            this.onboardDate = onboardDate;
            return this;
        }

        public Builder interviewDate(Date interviewDate) {
            this.interviewDate = interviewDate;
            return this;
        }

        public Builder resignDate(Date resignDate) {
            this.resignDate = resignDate;
            return this;
        }

        @Override
        public JobApplication build() {
            return new JobApplication(this);
        }
    }
}
