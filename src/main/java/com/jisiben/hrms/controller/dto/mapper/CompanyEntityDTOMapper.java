package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.CompanyDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.Company;
import com.jisiben.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyEntityDTOMapper extends AbstractMapper<Company, CompanyDTO> {

    @Autowired
    private UserService userService;

    @Override
    protected UserService getUserService() {
        return userService;
    }

    @Override
    public CompanyDTO toDTO(Company entity) {
        CompanyDTO.Builder builder = (CompanyDTO.Builder)super.entityToDTO(entity, new CompanyDTO.Builder());
        return builder
                .name(entity.getName())
                .city(entity.getCity())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .branchCount(entity.getBranches()!=null?entity.getBranches().size():0)
                .build();
    }

    @Override
    public Company toEntity(CompanyDTO dto, Company entity) {
        return entity.name(dto.getName())
                .city(dto.getCity())
                .address(dto.getAddress())
                .city(dto.getCity())
                .phone(dto.getPhone())
                .phone(dto.getPhone());
    }
}
