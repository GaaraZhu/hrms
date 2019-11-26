package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.Company;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.domain.entity.common.JobType;
import com.jisiben.hrms.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobEntityDTOMapper extends AbstractMapper<Job, JobDTO> {

    @Autowired
    private CompanyService companyService;

    @Override
    public JobDTO toDTO(Job entity) {
        JobDTO.Builder builder = (JobDTO.Builder)super.entityToDTO(entity, new JobDTO.Builder());
        return builder
                .company(entity.getCompany().getName())
                .companyId(entity.getCompany().getId())
                .city(entity.getCompany().getCity())
                .name(entity.getName())
                .salaryRange(entity.getSalaryRange())
                .type(entity.getType().getValue())
                .referralBonus(entity.isReferralBonus()?"有":"无")
                .referralBonusAmount(entity.getReferralBonusAmount())
                .active(entity.isActive()?"有效":"无效")
                .note(entity.getNote())
                .build();
    }

    @Override
    public Job toEntity(JobDTO dto, Job entity) {
        Company company = entity.getCompany();
        if (dto.getCompanyId()!=0) {
            company = companyService.findById(dto.getCompanyId()).get();
        }
        return entity.company(company)
                .name(dto.getName())
                .salaryRange(dto.getSalaryRange())
                .type(JobType.get(dto.getType()))
                .referralBonus(dto.getReferralBonus().equals("有"))
                .referralBonusAmount(dto.getReferralBonusAmount())
                .active(dto.getActive().equals("有效"))
                .note(dto.getNote());
    }
}