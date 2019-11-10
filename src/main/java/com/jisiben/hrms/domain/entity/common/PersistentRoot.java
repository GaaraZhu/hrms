package com.jisiben.hrms.domain.entity.common;

import java.util.Date;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class PersistentRoot<T extends PersistentRoot> {

    protected PersistentRoot(){}

    protected PersistentRoot(PersistentRoot.Builder builder) {
        this.jpaVersion = builder.jpaVersion;
        this.creator = builder.creator;
        this.createdTime = builder.createdTime;
        this.lastUpdater = builder.lastUpdater;
        this.lastUpdatedTime = builder.lastUpdatedTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int jpaVersion;

    @CreatedBy
    private String creator;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;

    @LastModifiedBy
    private String lastUpdater;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;

    public Long getId() {
        return id;
    }

    public int getJpaVersion() {
        return jpaVersion;
    }

    public String getCreator() {
        return creator;
    }

    public String getLastUpdater() {
        return lastUpdater;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public T jpaVersion(int jpaVersion) {
        this.jpaVersion = jpaVersion;
        return (T) this;
    }

    public T creator(String creator) {
        this.creator = creator;
        return (T) this;
    }

    public T createdTime(Date createdTime) {
        this.createdTime = createdTime;
        return (T)this;
    }

    public T lastUpdater(String lastUpdater) {
        this.lastUpdater = lastUpdater;
        return (T)this;
    }

    public T lastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
        return (T)this;
    }

    public static abstract class Builder<T extends PersistentRoot.Builder, D extends PersistentRoot> {

        private int jpaVersion;
        private String creator;
        private Date createdTime;
        private String lastUpdater;
        private Date lastUpdatedTime;

        public T creator(String creator) {
            this.creator = creator;
            return (T)this;
        }

        public T createdTime(Date createdTime) {
            this.createdTime = createdTime;
            return (T)this;
        }

        public T lastUpdater(String lastUpdater) {
            this.lastUpdater = lastUpdater;
            return (T)this;
        }

        public T lastUpdatedTime(Date lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
            return (T)this;
        }

        public T jpaVersion(int jpaVersion) {
            this.jpaVersion = jpaVersion;
            return (T)this;
        }

        public abstract D build();
    }
}
