package com.jisiben.hrms.controller.dto;

public class PairDTO {
    private String key;
    private Double value;

    public PairDTO(String key, Double value) {
        this.key = key;
        this.value  = value;
    }

    public String getKey() {
        return key;
    }

    public Double getVaue() {
        return value;
    }

}
