package com.jisiben.hrms.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyReportDTO {
    private String company;
    private String month;
    private Long quota;
    private String completePercentage;
    private Long dailyQuota;
    private String dailyCompletePercentage;
    private Long totalOnboarded;
    private Long totalResigned;
    private Long netOnboarded;

    public CompanyReportDTO() {
    }

    public CompanyReportDTO(Builder builder) {
        this.company=builder.company;
        this.month=builder.month;
        this.quota=builder.quota;
        this.completePercentage=builder.completePercentage;
        this.dailyQuota=builder.dailyQuota;
        this.dailyCompletePercentage=builder.dailyCompletePercentage;
        this.totalOnboarded=builder.totalOnboarded;
        this.totalResigned=builder.totalResigned;
        this.netOnboarded=builder.netOnboarded;
    }

    public String getCompany() {
        return company;
    }

    public String getMonth() {
        return month;
    }

    public Long getQuota() {
        return quota;
    }

    public String getCompletePercentage() {
        return completePercentage;
    }

    public Long getDailyQuota() {
        return dailyQuota;
    }

    public String getDailyCompletePercentage() {
        return dailyCompletePercentage;
    }

    public Long getTotalOnboarded() {
        return totalOnboarded;
    }

    public Long getTotalResigned() {
        return totalResigned;
    }

    public Long getNetOnboarded() {
        return netOnboarded;
    }

    public static class Builder {
        private String company;
        private String month;
        private Long quota;
        private String completePercentage;
        private Long dailyQuota;
        private String dailyCompletePercentage;
        private Long totalOnboarded;
        private Long totalResigned;
        private Long netOnboarded;

        public Builder company(String company) {
            this.company = company;
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

        public Builder completePercentage(String completePercentage) {
            this.completePercentage = completePercentage;
            return this;
        }

        public Builder dailyQuota(Long dailyQuota) {
            this.dailyQuota = dailyQuota;
            return this;
        }

        public Builder dailyCompletePercentage(String dailyCompletePercentage) {
            this.dailyCompletePercentage = dailyCompletePercentage;
            return this;
        }

        public Builder totalOnboarded(Long totalOnboarded) {
            this.totalOnboarded = totalOnboarded;
            return this;
        }

        public Builder totalResigned(Long totalResigned) {
            this.totalResigned = totalResigned;
            return this;
        }

        public Builder netOnboarded(Long netOnboarded) {
            this.netOnboarded = netOnboarded;
            return this;
        }

        public CompanyReportDTO build() {
            return new CompanyReportDTO(this);
        }
    }
}
