package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobQuotaDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.Branch;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.domain.entity.JobQuota;
import com.jisiben.hrms.service.BranchService;
import com.jisiben.hrms.service.JobQuotaService;
import com.jisiben.hrms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobQuotaEntityDTOMapper extends AbstractMapper<JobQuota, JobQuotaDTO> {

    @Autowired
    private JobQuotaService jobQuotaService;

    @Autowired
    private JobService jobService;

    @Autowired
    private BranchService branchService;

    @Override
    public JobQuotaDTO toDTO(JobQuota entity) {
        JobQuotaDTO.Builder builder = (JobQuotaDTO.Builder)super.entityToDTO(entity, new JobQuotaDTO.Builder());
        return builder
                .jobId(entity.getJob().getId())
                .branchId(entity.getBranch()!=null?entity.getBranch().getId():0l)
                .branch(entity.getBranch()!=null?entity.getBranch().getName():"")
                .jobName(entity.getJob().getName())
                .company(entity.getJob().getCompany().getName())
                .city(entity.getJob().getCompany().getCity())
                .month(entity.getMonth())
                .quota(entity.getQuota())
                .build();
    }

    @Override
    public JobQuota toEntity(JobQuotaDTO dto, JobQuota entity) {
        Job job = jobService.findById(dto.getJobId()).get();
        Branch branch = dto.getBranchId()!=0?branchService.findById(dto.getBranchId()).get():null;
        return entity
                .job(job)
                .branch(branch)
                .month(dto.getMonth())
                .quota(dto.getQuota());
    }
}
