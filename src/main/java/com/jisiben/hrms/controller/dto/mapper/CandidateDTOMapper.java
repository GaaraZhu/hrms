package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.CandidateDTO;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.domain.entity.common.Gender;

public class CandidateDTOMapper {
    public static CandidateDTO map(Candidate c) {
        return new CandidateDTO.Builder()
                .id(c.getId())
                .name(c.getName())
                .gender(c.getGender().equals(Gender.MALE)?"男":"女")
                .idNumber(c.getIdNumber())
                .phone(c.getPhone())
                .city(c.getCity())
                .address(c.getAddress())
                .build();
    }
}
