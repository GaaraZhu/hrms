package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.JobApplicationDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class JobApplicationDTOMapper implements Mapper<JobApplication, JobApplicationDTO> {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public JobApplicationDTO toDTO(JobApplication entity) {
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
                .status(entity.getStatus().getValue())
                .onBoardedTime(entity.getOnBoardedTime()!=null?sm.format(entity.getOnBoardedTime()):"")
                .resignedTime(entity.getResignedDate()!=null?sm.format(entity.getResignedDate()):"")
                .lastUpdatedTime(sm.format(entity.getLastUpdatedTime()))
                .build();
    }

    @Override
    public JobApplication toEntity(JobApplicationDTO dto, JobApplication entity) {
        Date onboardedTime = null;
        Date resignedTime = null;
        try{
            onboardedTime=sm.parse(dto.getOnBoardedTime());
            resignedTime=sm.parse(dto.getResignedTime());
        } catch (ParseException e) {
            logger.warning(String.format("failed to parse date: {} {}", dto.getOnBoardedTime(), dto.getResignedTime()));
        }
        return entity.referee(dto.getReferee())
                .refereePhone(dto.getRefereePhone())
                .status(JobApplicationStatus.valueOf(dto.getStatus()))
                .onBoardedTime(onboardedTime)
                .resignedTime(resignedTime);
    }
}
