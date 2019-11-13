package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.CandidateDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.domain.entity.common.Gender;
import org.springframework.stereotype.Component;

@Component
public class CandidateEntityDTOMapper extends AbstractMapper<Candidate, CandidateDTO> {
    @Override
    public CandidateDTO toDTO(Candidate entity) {
        CandidateDTO.Builder builder = (CandidateDTO.Builder)super.entityToDTO(entity, new CandidateDTO.Builder());
        return builder
                .name(entity.getName())
                .gender(entity.getGender().equals(Gender.MALE)?"男":"女")
                .idNumber(entity.getIdNumber())
                .phone(entity.getPhone())
                .ethnicity(entity.getEthnicity())
                .degree(entity.getDegree())
                .politicalStatus(entity.getPoliticalStatus())
                .bornAddress(entity.getBornAddress())
                .bank(entity.getBank())
                .bankAccount(entity.getBankAccount())
                .currentAddress(entity.getCurrentAddress())
                .emergencyContactName(entity.getEmergencyContactName())
                .emergencyContactRelationship(entity.getEmergencyContactRelationship())
                .emergencyContactPhone(entity.getEmergencyContactPhone())
                .build();
    }

    @Override
    public Candidate toEntity(CandidateDTO dto, Candidate entity) {
        return entity.name(dto.getName())
                .phone(dto.getPhone())
                .idNumber(dto.getIdNumber())
                .gender("男".equals(dto.getGender())? Gender.MALE:Gender.FEMALE)
                .bornAddress(dto.getBornAddress())
                .currentAddress(dto.getCurrentAddress())
                .ethnicity(dto.getEthnicity())
                .politicalStatus(dto.getPoliticalStatus())
                .degree(dto.getDegree())
                .bank(dto.getBank())
                .bankAccount(dto.getBankAccount())
                .emergencyContactName(dto.getEmergencyContactName())
                .emergencyContactPhone(dto.getEmergencyContactPhone())
                .emergencyContactRelationship(dto.getEmergencyContactRelationship());
    }
}
