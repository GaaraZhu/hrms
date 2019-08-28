package com.jisiben.hrms.controller.dto.common;

public abstract class DTORoot<T extends DTORoot> {
    private Long id;
    private String creator;
    private String createdTime;
    private String updater;
    private String updatedTime;

    public DTORoot() {}

    public DTORoot(Builder builder) {
        this.id = builder.id;
        this.creator = builder.creator;
        this.createdTime = builder.createdTime;
        this.updater = builder.updater;
        this.updatedTime = builder.updatedTime;
    }

    public Long getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getUpdater() {
        return updater;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public static abstract class Builder<T extends DTORoot.Builder, D extends DTORoot> {
        private Long id;
        private String creator;
        private String createdTime;
        private String updater;
        private String updatedTime;

        public T setId(Long id) {
            this.id = id;
            return (T)this;
        }

        public T setCreator(String creator) {
            this.creator = creator;
            return (T)this;
        }

        public T setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
            return (T)this;
        }

        public T setUpdater(String updater) {
            this.updater = updater;
            return (T)this;
        }

        public T setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
            return (T)this;
        }

        public T id(Long id) {
            this.id = id;
            return (T)this;
        }

        public abstract D build();
    }
}
