package com.jisiben.hrms.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jisiben.hrms.controller.dto.common.DTORoot;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobQuotaDTO extends DTORoot<JobQuotaDTO> {
    private long jobId;
    private long branchId;
    private String jobName;
    private String company;
    private String branch;
    private String city;
    private String district;
    private String month;
    private long quota;

    public JobQuotaDTO() {
    }

    private JobQuotaDTO(JobQuotaDTO.Builder builder) {
        super(builder);
        this.jobId=builder.jobId;
        this.branchId=builder.branchId;
        this.jobName=builder.jobName;
        this.company=builder.company;
        this.branch=builder.branch;
        this.city=builder.city;
        this.district=builder.district;
        this.month=builder.month;
        this.quota=builder.quota;
    }

    public String getJobName() {
        return jobName;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getMonth() {
        return month;
    }

    public long getQuota() {
        return quota;
    }

    public long getJobId() {
        return jobId;
    }

    public long getBranchId() {
        return branchId;
    }

    public String getBranch() {
        return branch;
    }

    public static class Builder extends DTORoot.Builder<JobQuotaDTO.Builder, JobQuotaDTO> {
        private long jobId;
        private long branchId;
        private String jobName;
        private String company;
        private String branch;
        private String city;
        private String district;
        private String month;
        private long quota;

        public Builder jobId(long jobId) {
            this.jobId = jobId;
            return this;
        }


        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder branchId(long branchId) {
            this.branchId = branchId;
            return this;
        }

        public Builder branch(String branch) {
            this.branch = branch;
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

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder quota(long quota) {
            this.quota = quota;
            return this;
        }

        public JobQuotaDTO build() {
            return new JobQuotaDTO(this);
        }
    }
}
