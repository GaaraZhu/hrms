package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.ApplicationReportType;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "applicationReport")
public class ApplicationReport extends PersistentRoot<ApplicationReport> {
    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name = "userId")
    private User user;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date end;

    private Long newApplied;

    private Long newInterviewed;

    private Long newOnboarded;

    @Enumerated(EnumType.STRING)
    private ApplicationReportType type;

    public ApplicationReport() {}

    public ApplicationReport(Builder builder) {
        this.user = builder.user;
        this.start = builder.start;
        this.end = builder.end;
        this.newApplied = builder.newApplied;
        this.newInterviewed = builder.newInterviewed;
        this.newOnboarded = builder.newOnboarded;
        this.type = builder.type;
    }

    public User getUser() {
        return user;
    }

    public ApplicationReport user(User user) {
        this.user = user;
        return this;
    }

    public Date getStart() {
        return start;
    }

    public ApplicationReport start(Date start) {
        this.start = start;
        return this;
    }

    public Date getEnd() {
        return end;
    }

    public ApplicationReport end(Date end) {
        this.end = end;
        return this;
    }

    public Long getNewApplied() {
        return newApplied;
    }

    public ApplicationReport newApplied(Long newApplied) {
        this.newApplied = newApplied;
        return this;
    }

    public Long getNewInterviewed() {
        return newInterviewed;
    }

    public ApplicationReport newlyInterviewed(Long newInterviewed) {
        this.newInterviewed = newInterviewed;
        return this;
    }

    public Long getNewOnboarded() {
        return newOnboarded;
    }

    public ApplicationReport newOnboarded(Long newOnboarded) {
        this.newOnboarded = newOnboarded;
        return this;
    }

    public ApplicationReportType getType() {
        return type;
    }

    public ApplicationReport type(ApplicationReportType type) {
        this.type = type;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, ApplicationReport> {
        private User user;
        private Date start;
        private Date end;
        private Long newApplied;
        private Long newInterviewed;
        private Long newOnboarded;
        private ApplicationReportType type;

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder start(Date start) {
            this.start = start;
            return this;
        }


        public Builder end(Date end) {
            this.end = end;
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

        public Builder type(ApplicationReportType type) {
            this.type = type;
            return this;
        }

        @Override
        public ApplicationReport build() {
            return new ApplicationReport(this);
        }
    }

}
