package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.PersonalReportDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.PersonalReport;
import com.jisiben.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonalReportEntityDTOMapper extends AbstractMapper<PersonalReport, PersonalReportDTO> {

    @Autowired
    private UserService userService;

    @Override
    protected UserService getUserService() {
        return userService;
    }

    @Override
    public PersonalReportDTO toDTO(PersonalReport entity) {
        PersonalReportDTO.Builder builder = (PersonalReportDTO.Builder)super.entityToDTO(entity, new PersonalReportDTO.Builder());
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
    public PersonalReport toEntity(PersonalReportDTO dto, PersonalReport entity) {
        throw new UnsupportedOperationException("Application Report is supposed to be generated automatically by system");
    }
}
