package com.jisiben.hrms.domain.entity;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import com.jisiben.hrms.domain.entity.common.PersonalReportType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personalReport")
public class PersonalReport extends PersistentRoot<PersonalReport> {
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
    private PersonalReportType type;

    public PersonalReport() {}

    public PersonalReport(Builder builder) {
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

    public PersonalReport user(User user) {
        this.user = user;
        return this;
    }

    public Date getStart() {
        return start;
    }

    public PersonalReport start(Date start) {
        this.start = start;
        return this;
    }

    public Date getEnd() {
        return end;
    }

    public PersonalReport end(Date end) {
        this.end = end;
        return this;
    }

    public Long getNewApplied() {
        return newApplied;
    }

    public PersonalReport newApplied(Long newApplied) {
        this.newApplied = newApplied;
        return this;
    }

    public Long getNewInterviewed() {
        return newInterviewed;
    }

    public PersonalReport newlyInterviewed(Long newInterviewed) {
        this.newInterviewed = newInterviewed;
        return this;
    }

    public Long getNewOnboarded() {
        return newOnboarded;
    }

    public PersonalReport newOnboarded(Long newOnboarded) {
        this.newOnboarded = newOnboarded;
        return this;
    }

    public PersonalReportType getType() {
        return type;
    }

    public PersonalReport type(PersonalReportType type) {
        this.type = type;
        return this;
    }

    public static class Builder extends PersistentRoot.Builder<Builder, PersonalReport> {
        private User user;
        private Date start;
        private Date end;
        private Long newApplied;
        private Long newInterviewed;
        private Long newOnboarded;
        private PersonalReportType type;

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

        public Builder type(PersonalReportType type) {
            this.type = type;
            return this;
        }

        @Override
        public PersonalReport build() {
            return new PersonalReport(this);
        }
    }

}
