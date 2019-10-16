package com.jisiben.hrms.domain.entity.common;

import java.util.HashMap;
import java.util.Map;

public enum JobType {
    FULL_TIME("全职"), PART_TIME("兼职"), CONTRACTOR("小时工");

    private static final Map<String, JobType> lookup = new HashMap<String, JobType>();
    static {
        for (JobType type : JobType.values()) {
            lookup.put(type.value, type);
        }
    }

    private String value;

    public String getValue(){
        return value;
    }

    JobType(String value) {
        this.value = value;
    }

    public static JobType get(String value) {
        return lookup.get(value);
    }
}
