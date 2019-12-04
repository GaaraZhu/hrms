package com.jisiben.hrms.controller.dto;

public class MonthlyStuffReportDTO {
    private String company;
    private String city;
    private String district;
    private String branch;
    private String month;
    private long firstDayCount;
    private long lastDayCount;

    MonthlyStuffReportDTO() {}

    MonthlyStuffReportDTO(Builder builder) {
        this.company=builder.company;
        this.city=builder.city;
        this.district=builder.district;
        this.branch=builder.branch;
        this.month=builder.month;
        this.firstDayCount=builder.firstDayCount;
        this.lastDayCount=builder.lastDayCount;
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

    public String getBranch() {
        return branch;
    }

    public String getMonth() {
        return month;
    }

    public long getFirstDayCount() {
        return firstDayCount;
    }

    public long getLastDayCount() {
        return lastDayCount;
    }

    public static class Builder {
        private String company;
        private String city;
        private String district;
        private String branch;
        private String month;
        private long firstDayCount;
        private long lastDayCount;

        public Builder() {}

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

        public Builder branch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder firstDayCount(long firstDayCount) {
            this.firstDayCount = firstDayCount;
            return this;
        }

        public Builder lastDayCount(long lastDayCount) {
            this.lastDayCount = lastDayCount;
            return this;
        }

        public MonthlyStuffReportDTO build() {
            return new MonthlyStuffReportDTO(this);
        }
    }

}
