package com.jisiben.hrms.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jisiben.hrms.controller.dto.common.DTORoot;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobApplicationDTO extends DTORoot<JobApplicationDTO> {
    private long candidateId;
    private long jobId;
    private String candidateName;
    private String phone;
    private String idNumber;
    private String referee;
    private String refereePhone;
    private String company;
    private String city;
    private String district;
    private String jobName;
    private String status;
    private String applicationDate;
    private String interviewDate;
    private String onboardDate;
    private String resignDate;
    private String lastUpdatedTime;

    public JobApplicationDTO() {
    }

    private JobApplicationDTO(JobApplicationDTO.Builder builder) {
        super(builder);
        this.candidateId=builder.candidateId;
        this.jobId=builder.jobId;
        this.candidateName=builder.candidateName;
        this.phone=builder.phone;
        this.idNumber=builder.idNumber;
        this.referee=builder.referee;
        this.refereePhone=builder.refereePhone;
        this.company=builder.company;
        this.city=builder.city;
        this.district=builder.district;
        this.jobName=builder.jobName;
        this.status=builder.status;
        this.applicationDate=builder.applicationDate;
        this.interviewDate=builder.interviewDate;
        this.onboardDate=builder.onboardDate;
        this.resignDate=builder.resignDate;
        this.lastUpdatedTime=builder.lastUpdatedTime;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getReferee() {
        return referee;
    }

    public String getRefereePhone() {
        return refereePhone;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getJobName() {
        return jobName;
    }

    public String getStatus() {
        return status;
    }

    public String getOnboardDate() {
        return onboardDate;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getResignDate() {
        return resignDate;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public String getDistrict() {
        return district;
    }

    public long getCandidateId() {
        return candidateId;
    }

    public long getJobId() {
        return jobId;
    }

    public static class Builder extends DTORoot.Builder<JobApplicationDTO.Builder, JobApplicationDTO> {
        private long candidateId;
        private long jobId;
        private String candidateName;
        private String phone;
        private String idNumber;
        private String referee;
        private String refereePhone;
        private String company;
        private String city;
        private String district;
        private String jobName;
        private String status;
        private String applicationDate;
        private String interviewDate;
        private String onboardDate;
        private String resignDate;
        private String lastUpdatedTime;


        public Builder applicationDate(String applicationDate) {
            this.applicationDate = applicationDate;
            return this;
        }

        public Builder interviewDate(String interviewDate) {
            this.interviewDate = interviewDate;
            return this;
        }

        public Builder candidateId(long candidateId) {
            this.candidateId = candidateId;
            return this;
        }

        public Builder jobId(long jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder candidateName(String candidateName) {
            this.candidateName = candidateName;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder idNumber(String idNumber) {
            this.idNumber = idNumber;
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

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder district(String district) {
            this.district = district;
            return this;
        }

        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder onboardDate(String onboardDate) {
            this.onboardDate = onboardDate;
            return this;
        }

        public Builder resignDate(String resignDate) {
            this.resignDate = resignDate;
            return this;
        }

        public Builder lastUpdatedTime(String lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
            return this;
        }

        public JobApplicationDTO build() {
            return new JobApplicationDTO(this);
        }
    }
}
