package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobApplicationDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.JobApplication;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class JobApplicationDTOMapper implements Mapper<JobApplication, JobApplicationDTO> {
    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public JobApplicationDTO toDTO(JobApplication entity) {
        String onBoardedOrResignedTime;
        if (entity.getOnBoardedTime() != null) {
            onBoardedOrResignedTime = sm.format(entity.getOnBoardedTime());
        } else {
            onBoardedOrResignedTime = sm.format(entity.getResignedDate());
        }
        return new JobApplicationDTO.Builder()
                .id(entity.getId())
                .name(entity.getCandidate().getName())
                .phone(entity.getCandidate().getPhone())
                .idNumber(entity.getCandidate().getIdNumber())
                .referee(entity.getReferee())
                .refereePhone(entity.getRefereePhone())
                .company(entity.getJob().getCompany())
                .city(entity.getJob().getCity())
                .jobName(entity.getJob().getName())
                .applicationTime(sm.format(entity.getCreatedTime()))
                .status(entity.getStatus().toString())
                .onBoardedOrResignedTime(onBoardedOrResignedTime)
                .lastUpdatedTime(sm.format(entity.getLastUpdatedTime()))
                .build();
    }

    @Override
    public JobApplication toEntity(JobApplicationDTO dto, JobApplication entity) {
        return entity; //TODO: FIXME
    }
}
