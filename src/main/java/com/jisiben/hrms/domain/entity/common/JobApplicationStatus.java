package com.jisiben.hrms.domain.entity.common;

import java.util.HashMap;
import java.util.Map;

public enum JobApplicationStatus {
    NEW("未处理"),
    FAILED("申请失败"),
    WAITING_INTERVIEW("等待面试"),
    INTERVIEWED("完成面试"),
    INTERVIEW_PASSED("面试通过"),
    INTERVIEW_FAILED("面试失败"),
    ON_BOARDED("入职"),
    ON_BOARDED_ONE_MONTH("入职满1月"),
    ON_BOARDED_THREE_MONTHS("入职满3月"),
    ON_BOARDED_SIX_MONTHS("入职满6月"),
    RESIGNED("离职");

    private String value;

    public String getValue(){
        return value;
    }

    JobApplicationStatus(String value) {
        this.value = value;
    }

    private static final Map<String, JobApplicationStatus> lookup = new HashMap<String, JobApplicationStatus>();
    static {
        for (JobApplicationStatus status : JobApplicationStatus.values()) {
            lookup.put(status.value, status);
        }
    }

    public static JobApplicationStatus get(String value) {
        return lookup.get(value);
    }
}
