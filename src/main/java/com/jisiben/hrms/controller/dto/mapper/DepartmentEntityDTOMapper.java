package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.DepartmentDTO;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentEntityDTOMapper implements Mapper<Department, DepartmentDTO> {
    @Override
    public DepartmentDTO toDTO(Department entity) {
        return new DepartmentDTO.Builder()
                .id(entity.getId())
                .name(entity.getName())
                .number(entity.getNumber())
                .manager(entity.getManager())
                .telephone(entity.getTelephone())
                .build();
    }

    @Override
    public Department toEntity(DepartmentDTO dto, Department entity) {
        return entity.name(dto.getName())
                .number(dto.getNumber())
                .manager(dto.getManager())
                .telephone(dto.getTelephone());
    }
}
