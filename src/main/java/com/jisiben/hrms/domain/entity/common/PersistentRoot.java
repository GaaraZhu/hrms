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
        this.createdBy = builder.createdBy;
        this.createdTime = builder.createdTime;
        this.lastUpdatedBy = builder.lastUpdatedBy;
        this.lastUpdatedTime = builder.lastUpdatedTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int jpaVersion;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;

    @LastModifiedBy
    private String lastUpdatedBy;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;

    public Long getId() {
        return id;
    }

    public int getJpaVersion() {
        return jpaVersion;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
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

    public T createdBy(String createdBy) {
        this.createdBy = createdBy;
        return (T) this;
    }

    public T createdTime(Date createdTime) {
        this.createdTime = createdTime;
        return (T)this;
    }

    public T lastUpdatedBy(String lastUpdateBy) {
        this.lastUpdatedBy = lastUpdatedBy;
        return (T)this;
    }

    public T lastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
        return (T)this;
    }

    public static abstract class Builder<T extends PersistentRoot.Builder, D extends PersistentRoot> {

        private int jpaVersion;
        private String createdBy;
        private Date createdTime;
        private String lastUpdatedBy;
        private Date lastUpdatedTime;

        public T setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return (T)this;
        }

        public T setCreatedTime(Date createdTime) {
            this.createdTime = createdTime;
            return (T)this;
        }

        public T setLastUpdatedBy(String lastUpdatedBy) {
            this.lastUpdatedBy = lastUpdatedBy;
            return (T)this;
        }

        public T setLastUpdatedTime(Date lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
            return (T)this;
        }

        public T setJpaVersion(int jpaVersion) {
            this.jpaVersion = jpaVersion;
            return (T)this;
        }

        public abstract D build();
    }
}
