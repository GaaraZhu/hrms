package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.BranchDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Branch;
import com.jisiben.hrms.service.BranchService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class BranchServiceImpl extends AbstractService<Branch> implements BranchService {

    @Autowired
    private BranchDao branchDao;

    @Override
    public Dao<Branch, Long> getDao() {
        return branchDao;
    }

    @Override
    public Page<Branch> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String manager = criteria.get("manager").map(Object::toString).orElse(null);
        String name = criteria.get("name").map(Object::toString).orElse(null);
        return branchDao.findByManagerAndName(manager, name, new PageRequest(currentPage-1, pageSize));
    }
}
