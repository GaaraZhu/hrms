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

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class BranchServiceImpl extends AbstractService<Branch> implements BranchService {

    @Autowired
    private BranchDao branchDao;

    @Override
    protected Dao<Branch, Long> getDao() {
        return branchDao;
    }

    @Override
    public Page<Branch> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String company = criteria.get("company").map(Object::toString).orElse(null);
        String branch = criteria.get("branch").map(Object::toString).orElse(null);
        return branchDao.findByManagerAndName(company, branch, new PageRequest(currentPage-1, pageSize));
    }
}
