package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.domain.entity.common.JobType;
import org.springframework.stereotype.Component;

@Component
public class JobEntityDTOMapper extends AbstractMapper<Job, JobDTO> {

    @Override
    public JobDTO toDTO(Job entity) {
        JobDTO.Builder builder = (JobDTO.Builder)super.entityToDTO(entity, new JobDTO.Builder());
        return builder
                .company(entity.getCompany())
                .city(entity.getCity())
                .district(entity.getDistrict())
                .address(entity.getAddress())
                .name(entity.getName())
                .salaryRange(entity.getSalaryRange())
                .type(entity.getType().getValue())
                .quota(entity.getQuota())
                .referralBonus(entity.isReferralBonus()?"有":"无")
                .referralBonusAmount(entity.getReferralBonusAmount())
                .active(entity.isActive()?"有效":"无效")
                .note(entity.getNote())
                .build();
    }

    @Override
    public Job toEntity(JobDTO dto, Job entity) {
        return entity.company(dto.getCompany())
                .city(dto.getCity())
                .district(dto.getDistrict())
                .address(dto.getAddress())
                .name(dto.getName())
                .salaryRange(dto.getSalaryRange())
                .type(JobType.get(dto.getType()))
                .quota(dto.getQuota())
                .referralBonus(dto.getReferralBonus().equals("有"))
                .referralBonusAmount(dto.getReferralBonusAmount())
                .active(dto.getActive().equals("有效"))
                .note(dto.getNote());
    }
}