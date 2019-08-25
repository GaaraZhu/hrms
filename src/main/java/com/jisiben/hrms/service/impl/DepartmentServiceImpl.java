package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.DepartmentDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Department;
import com.jisiben.hrms.service.DepartmentService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentServiceImpl extends AbstractService<Department> implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Dao<Department, Long> getDao() {
        return departmentDao;
    }

    @Override
    public Page<Department> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String depNumber = criteria.get("depNum").map(Object::toString).orElse(null);
        String depName = criteria.get("depName").map(Object::toString).orElse(null);
        return departmentDao.findByNumberAndName(depNumber, depName, new PageRequest(currentPage-1, pageSize));
    }
}
