package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.Department;
import com.jisiben.hrms.service.common.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService extends Service<Department> {
    Page<Department> search(String depNumber, String depName, Pageable pageable);
}
