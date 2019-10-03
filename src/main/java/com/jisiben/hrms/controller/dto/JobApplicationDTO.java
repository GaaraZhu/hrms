package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class JobApplicationDTO extends DTORoot<JobApplicationDTO> {
    private String name;
    private String phone;
    private String idNumber;
    private String referee;
    private String refereePhone;
    private String company;
    private String city;
    private String jobName;
    private String applicationTime;
    private String status;
    private String onBoardedOrResignedTime;
    private String lastUpdatedTime;

    public JobApplicationDTO() {
    }

    private JobApplicationDTO(JobApplicationDTO.Builder builder) {
        super(builder);
        this.name=builder.name;
        this.phone=builder.phone;
        this.idNumber=builder.idNumber;
        this.referee=builder.referee;
        this.refereePhone=builder.refereePhone;
        this.company=builder.company;
        this.city=builder.city;
        this.jobName=builder.jobName;
        this.applicationTime=builder.applicationTime;
        this.status=builder.status;
        this.onBoardedOrResignedTime=builder.onBoardedOrResignedTime;
        this.lastUpdatedTime=builder.lastUpdatedTime;
    }

    public String getName() {
        return name;
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

    public String getApplicationTime() {
        return applicationTime;
    }

    public String getStatus() {
        return status;
    }

    public String getOnBoardedOrResignedTime() {
        return onBoardedOrResignedTime;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public static class Builder extends DTORoot.Builder<JobApplicationDTO.Builder, JobApplicationDTO> {
        private String name;
        private String phone;
        private String idNumber;
        private String referee;
        private String refereePhone;
        private String company;
        private String city;
        private String jobName;
        private String applicationTime;
        private String status;
        private String onBoardedOrResignedTime;
        private String lastUpdatedTime;

        public Builder name(String name) {
            this.name = name;
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

        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder applicationTime(String applicationTime) {
            this.applicationTime = applicationTime;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder onBoardedOrResignedTime(String onBoardedOrResignedTime) {
            this.onBoardedOrResignedTime = onBoardedOrResignedTime;
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
