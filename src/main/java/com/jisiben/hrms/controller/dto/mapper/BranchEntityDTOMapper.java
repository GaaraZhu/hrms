package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.BranchDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchEntityDTOMapper implements Mapper<Branch, BranchDTO> {
    @Override
    public BranchDTO toDTO(Branch entity) {
        return new BranchDTO.Builder()
                .id(entity.getId())
                .name(entity.getName())
                .manager(entity.getManager())
                .address(entity.getAddress())
                .telephone(entity.getTelephone())
                .build();
    }

    @Override
    public Branch toEntity(BranchDTO dto, Branch entity) {
        return entity.name(dto.getName())
                .manager(dto.getManager())
                .address(dto.getAddress())
                .telephone(dto.getTelephone());
    }
}
