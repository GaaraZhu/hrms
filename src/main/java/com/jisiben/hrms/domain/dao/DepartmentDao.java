package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentDao extends Dao<Department, Long> {
    Page<Department> findByNumberOrName(String depNumber, String depName, Pageable pageable);
}
