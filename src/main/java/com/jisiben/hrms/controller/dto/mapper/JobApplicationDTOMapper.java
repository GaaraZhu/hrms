package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobApplicationDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import com.jisiben.hrms.service.CandidateService;
import com.jisiben.hrms.service.JobService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class JobApplicationDTOMapper extends AbstractMapper<JobApplication, JobApplicationDTO> {

    @Autowired
    private JobService jobService;

    @Autowired
    private CandidateService candidateService;

    @Override
    public JobApplicationDTO toDTO(JobApplication entity) {
        JobApplicationDTO.Builder builder = (JobApplicationDTO.Builder)super.entityToDTO(entity, new JobApplicationDTO.Builder());
        return builder
                .jobId(entity.getJob().getId())
                .candidateId(entity.getCandidate().getId())
                .candidateName(entity.getCandidate().getName())
                .phone(entity.getCandidate().getPhone())
                .idNumber(entity.getCandidate().getIdNumber())
                .referee(entity.getReferee())
                .refereePhone(entity.getRefereePhone())
                .company(entity.getJob().getCompany())
                .city(entity.getJob().getCity())
                .district(entity.getJob().getDistrict())
                .jobName(entity.getJob().getName())
                .status(entity.getStatus().getValue())
                .applicationDate(entity.getApplicationDate()!=null?sm.format(entity.getApplicationDate()):"")
                .interviewDate(entity.getInterviewDate()!=null?sm.format(entity.getInterviewDate()):"")
                .onboardDate(entity.getOnboardDate()!=null?sm.format(entity.getOnboardDate()):"")
                .resignDate(entity.getResignDate()!=null?sm.format(entity.getResignDate()):"")
                .build();
    }

    @Override
    public JobApplication toEntity(JobApplicationDTO dto, JobApplication entity) {
        Date onboardDate = entity.getOnboardDate();
        Date resignDate = entity.getResignDate();
        Date interviewDate = entity.getInterviewDate();
        Date applicationDate = entity.getApplicationDate();
        Job job = jobService.findById(dto.getJobId()).get();
        Candidate candidate = candidateService.findById(dto.getCandidateId()).get();
        return entity
                .job(job)
                .candidate(candidate)
                .referee(dto.getReferee())
                .refereePhone(dto.getRefereePhone())
                .status(JobApplicationStatus.get(dto.getStatus()))
                .applicationDate(applicationDate)
                .interviewDate(interviewDate)
                .onboardDate(onboardDate)
                .resignDate(resignDate);
    }
}
