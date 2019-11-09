package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.ApplicationReportDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.ApplicationReport;

public class ApplicationReportDTOMapper extends AbstractMapper<ApplicationReport, ApplicationReportDTO> {
    @Override
    public ApplicationReportDTO toDTO(ApplicationReport entity) {
        return new ApplicationReportDTO.Builder()
                .name(entity.getUser().getName())
                .newApplied(entity.getNewApplied())
                .newInterviewed(entity.getNewInterviewed())
                .newOnboarded(entity.getNewOnboarded())
                .fromDate(sm.format(entity.getStart()))
                .toDate(sm.format(entity.getEnd()))
                .setType(entity.getType().toString())
                .build();
    }

    @Override
    public ApplicationReport toEntity(ApplicationReportDTO dto, ApplicationReport entity) {
        throw new UnsupportedOperationException("Application Report is supposed to be generated automatically by system");
    }
}
