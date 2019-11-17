package com.jisiben.hrms.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jisiben.hrms.controller.dto.common.DTORoot;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobQuotaDTO extends DTORoot<JobQuotaDTO> {
    private long jobId;
    private String month;
    private int quota;

    public JobQuotaDTO() {
    }

    private JobQuotaDTO(JobQuotaDTO.Builder builder) {
        super(builder);
        this.jobId=builder.jobId;
        this.month=builder.month;
        this.quota=builder.quota;
    }

    public String getMonth() {
        return month;
    }

    public int getQuota() {
        return quota;
    }

    public long getJobId() {
        return jobId;
    }

    public static class Builder extends DTORoot.Builder<JobQuotaDTO.Builder, JobQuotaDTO> {
        private long jobId;
        private String month;
        private int quota;

        public Builder jobId(long jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder quota(int quota) {
            this.quota = quota;
            return this;
        }

        public JobQuotaDTO build() {
            return new JobQuotaDTO(this);
        }
    }
}
