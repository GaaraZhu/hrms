package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.domain.entity.common.JobType;
import org.springframework.stereotype.Component;

@Component
public class JobEntityDTOMapper implements Mapper<Job, JobDTO> {
    @Override
    public JobDTO toDTO(Job entity) {
        return new JobDTO.Builder()
                .id(entity.getId())
                .setCompany(entity.getCompany())
                .setCity(entity.getCity())
                .setName(entity.getName())
                .setSalaryRange(entity.getSalaryRange())
                .setType(entity.getType().toString())
                .setQuota(entity.getQuota())
                .setReferralBonus(entity.isReferralBonus())
                .setReferralBonusAmount(entity.getReferralBonusAmount())
                .setActive(entity.isActive())
                .setNote(entity.getNote())
                .setCreator(entity.getCreatedBy())
                .setCreatedTime(entity.getCreatedTime().toString())
                .setUpdater(entity.getLastUpdatedBy())
                .setUpdatedTime(entity.getLastUpdatedTime().toString())
                .build();
    }

    @Override
    public Job toEntity(JobDTO dto, Job entity) {
        return entity.company(dto.getCompany())
                .city(dto.getCity())
                .name(dto.getName())
                .salaryRange(dto.getSalaryRange())
                .type(JobType.valueOf(dto.getType()))
                .quota(dto.getQuota())
                .referralBonus(dto.isReferralBonus())
                .referralBonusAmount(dto.getReferralBonusAmount())
                .active(dto.isActive())
                .note(dto.getNote());
    }
}