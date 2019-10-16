package com.jisiben.hrms.domain.entity.common;

public enum JobApplicationStatus {
    NEW("未处理"),
    FAILED("申请失败"),
    WAITING_INTERVIEW("等待面试"),
    INTERVIEWED("完成面试"),
    INTERVIEW_PASSED("面试通过"),
    INTERVIEW_FAILED("面试失败"),
    ON_BOARDED("入职"),
    ON_BOARDED_ONE_ONE_MONTH("入职满1月"),
    ON_BOARDED_ONE_THREE_MONTH("入职满3月"),
    ON_BOARDED_ONE_SIX_MONTH("入职满6月"),
    RESIGNED("离职");

    private String value;

    public String getValue(){
        return value;
    }

    JobApplicationStatus(String value) {
        this.value = value;
    }
}
