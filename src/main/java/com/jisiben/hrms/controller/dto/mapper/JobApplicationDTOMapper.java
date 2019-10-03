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
        return new JobApplicationDTO.Builder() //TODO: FIXME
                .id(entity.getId())
                .build();
    }

    @Override
    public JobApplication toEntity(JobApplicationDTO dto, JobApplication entity) {
        return entity; //TODO: FIXME
    }
}
