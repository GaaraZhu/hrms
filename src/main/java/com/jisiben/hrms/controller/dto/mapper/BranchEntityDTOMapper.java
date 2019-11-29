package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.BranchDTO;
import com.jisiben.hrms.controller.dto.mapper.common.impl.AbstractMapper;
import com.jisiben.hrms.domain.entity.Branch;
import com.jisiben.hrms.domain.entity.Company;
import com.jisiben.hrms.service.CompanyService;
import com.jisiben.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchEntityDTOMapper extends AbstractMapper<Branch, BranchDTO> {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Override
    protected UserService getUserService() {
        return userService;
    }

    @Override
    public BranchDTO toDTO(Branch entity) {
        BranchDTO.Builder builder = (BranchDTO.Builder)super.entityToDTO(entity, new BranchDTO.Builder());
        return builder
                .name(entity.getName())
                .company(entity.getCompany().getName())
                .city(entity.getCompany().getCity())
                .manager(entity.getManager())
                .address(entity.getAddress())
                .district(entity.getDistrict())
                .phone(entity.getPhone())
                .build();
    }

    @Override
    public Branch toEntity(BranchDTO dto, Branch entity) {
        Company company = entity.getCompany();
        if (dto.getCompanyId()!=0) {
            company = companyService.findById(dto.getCompanyId()).get();
        }
        return entity.name(dto.getName())
                .company(company)
                .manager(dto.getManager())
                .address(dto.getAddress())
                .district(dto.getDistrict())
                .phone(dto.getPhone());
    }

}
