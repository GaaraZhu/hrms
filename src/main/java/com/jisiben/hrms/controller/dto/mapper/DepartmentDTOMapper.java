package com.jisiben.hrms.controller.dto.mapper;

import com.jisiben.hrms.controller.dto.DepartmentDTO;
import com.jisiben.hrms.domain.entity.Department;

public class DepartmentDTOMapper {
    public static DepartmentDTO map(Department dep) {
        return new DepartmentDTO.Builder()
                .id(dep.getId())
                .name(dep.getName())
                .number(dep.getNumber())
                .manager(dep.getManager())
                .telephone(dep.getTelephone())
                .build();
    }
}
