package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class ApplicationReportDTO extends DTORoot<ApplicationReportDTO> {
    private String name;
    private Long newApplied;
    private Long newInterviewed;
    private Long newOnboarded;
    private String fromDate;
    private String toDate;
    private String type;

    public ApplicationReportDTO() {
    }

    public ApplicationReportDTO(Builder builder) {
        this.name = builder.name;
        this.newApplied = builder.newApplied;
        this.newInterviewed = builder.newInterviewed;
        this.newOnboarded = builder.newOnboarded;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
        this.type = builder.type;
    }

    public static class Builder extends DTORoot.Builder<ApplicationReportDTO.Builder, ApplicationReportDTO> {
        private String name;
        private Long newApplied;
        private Long newInterviewed;
        private Long newOnboarded;
        private String fromDate;
        private String toDate;
        private String type;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder newApplied(Long newApplied) {
            this.newApplied = newApplied;
            return this;
        }

        public Builder newInterviewed(Long newInterviewed) {
            this.newInterviewed = newInterviewed;
            return this;
        }

        public Builder newOnboarded(Long newOnboarded) {
            this.newOnboarded = newOnboarded;
            return this;
        }

        public Builder fromDate(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public Builder toDate(String toDate) {
            this.toDate = toDate;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public ApplicationReportDTO build() {
            return null;
        }
    }
}
