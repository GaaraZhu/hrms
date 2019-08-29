package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.domain.entity.common.JobType;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class JobEntityDTOMapper implements Mapper<Job, JobDTO> {
    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public JobDTO toDTO(Job entity) {
        return new JobDTO.Builder()
                .id(entity.getId())
                .setCompany(entity.getCompany())
                .setCity(entity.getCity())
                .setName(entity.getName())
                .setSalaryRange(entity.getSalaryRange())
                .setType(entity.getType().getValue())
                .setQuota(entity.getQuota())
                .setReferralBonus(entity.isReferralBonus()?"有":"无")
                .setReferralBonusAmount(entity.getReferralBonusAmount())
                .setActive(entity.isActive()?"是":"否")
                .setNote(entity.getNote())
                .setCreator(entity.getCreatedBy())
                .setCreatedTime(sm.format(entity.getCreatedTime()))
                .setUpdater(entity.getLastUpdatedBy())
                .setUpdatedTime(sm.format(entity.getLastUpdatedTime()))
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
                .referralBonus(dto.getReferralBonus().equals("有")?true:false)
                .referralBonusAmount(dto.getReferralBonusAmount())
                .active(dto.getActive().equals("有")?true:false)
                .note(dto.getNote());
    }
}