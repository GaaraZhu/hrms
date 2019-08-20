package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.DepartmentDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Department;
import com.jisiben.hrms.service.DepartmentService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends AbstractService<Department> implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Dao<Department, Long> getDao() {
        return departmentDao;
    }
}
