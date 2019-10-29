package com.jisiben.hrms.domain.entity.common;

import java.util.HashMap;
import java.util.Map;

public enum ReferralBonusStatus {
    PENDING_APPROVE("待审批"), APPROVED("待发放"), TRANSFERRED("已发放");

    private static final Map<String, ReferralBonusStatus> lookup = new HashMap<>();
    static {
        for (ReferralBonusStatus status : ReferralBonusStatus.values()) {
            lookup.put(status.value, status);
        }
    }

    private String value;

    public String getValue(){
        return value;
    }

    ReferralBonusStatus(String value) {
        this.value = value;
    }

    public static ReferralBonusStatus get(String value) {
        return lookup.get(value);
    }
}
