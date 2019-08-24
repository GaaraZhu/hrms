package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.CandidateDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.domain.entity.common.Gender;
import org.springframework.stereotype.Component;

@Component
public class CandidateEntityDTOMapper implements Mapper<Candidate, CandidateDTO> {
    @Override
    public CandidateDTO toDTO(Candidate entity) {
        return new CandidateDTO.Builder()
                .id(entity.getId())
                .name(entity.getName())
                .gender(entity.getGender().equals(Gender.MALE)?"男":"女")
                .idNumber(entity.getIdNumber())
                .phone(entity.getPhone())
                .city(entity.getCity())
                .address(entity.getAddress())
                .build();
    }

    @Override
    public Candidate toEntity(CandidateDTO dto, Candidate entity) {
        return entity.name(dto.getName())
                .phone(dto.getPhone())
                .idNumber(dto.getIdNumber())
                .gender("男".equals(dto.getGender())? Gender.MALE:Gender.FEMALE)
                .city(dto.getCity())
                .address(dto.getAddress());
    }
}
