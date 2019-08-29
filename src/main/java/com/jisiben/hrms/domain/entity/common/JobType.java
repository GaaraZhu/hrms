package com.jisiben.hrms.domain.entity.common;

public enum JobType {
    FULL_TIME("全职"), PART_TIME("兼职"), CONTRACTOR("小时工");

    private String value;

    public String getValue(){
        return value;
    }

    private JobType(String value) {
        this.value = value;
    }
}
