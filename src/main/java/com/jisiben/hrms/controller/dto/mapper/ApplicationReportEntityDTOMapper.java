package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.ApplicationReportDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.ApplicationReport;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReportEntityDTOMapper extends AbstractMapper<ApplicationReport, ApplicationReportDTO> {
    @Override
    public ApplicationReportDTO toDTO(ApplicationReport entity) {
        ApplicationReportDTO.Builder builder = (ApplicationReportDTO.Builder)super.entityToDTO(entity, new ApplicationReportDTO.Builder());
        return builder
                .name(entity.getUser().getName())
                .newApplied(entity.getNewApplied())
                .newInterviewed(entity.getNewInterviewed())
                .newOnboarded(entity.getNewOnboarded())
                .fromDate(sm.format(entity.getStart()))
                .toDate(sm.format(entity.getEnd()))
                .type(entity.getType().toString())
                .build();
    }

    @Override
    public ApplicationReport toEntity(ApplicationReportDTO dto, ApplicationReport entity) {
        throw new UnsupportedOperationException("Application Report is supposed to be generated automatically by system");
    }
}
