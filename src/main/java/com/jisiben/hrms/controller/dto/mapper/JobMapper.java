package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobDTO;
import com.jisiben.hrms.domain.entity.Job;

public class JobMapper {
    public static JobDTO map(Job job) {
        return new JobDTO.Builder()
                .setId(job.getId())
                .setCompany(job.getCompany())
                .setCity(job.getCity())
                .setName(job.getName())
                .setSalaryRange(job.getSalaryRange())
                .setType(job.getType().toString())
                .setQuota(job.getQuota())
                .setReferralBonus(job.isReferralBonus())
                .setReferralBonusAmount(job.getReferralBonusAmount())
                .setBonusCondition(job.getBonusCondition().toString())
                .build();
    }
}