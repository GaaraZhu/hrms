package com.jisiben.hrms.controller.dto.common;

public abstract class DTORoot<T extends DTORoot> {
    private Long id;

    public DTORoot() {}

    public DTORoot(Builder builder) {
        this.id = builder.id;
    }

    public Long getId() {
        return id;
    }

    public static abstract class Builder<T extends DTORoot.Builder, D extends DTORoot> {
        private Long id;

        public T id(Long id) {
            this.id = id;
            return (T)this;
        }

        public abstract D build();
    }
}
