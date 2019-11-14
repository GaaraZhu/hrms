package com.jisiben.hrms.domain.dao.bean;

public class Pair {
    private String key;
    private Long value;

    public Pair(String key, Long value) {
        this.key = key;
        this.value  = value;
    }

    public String getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

}
