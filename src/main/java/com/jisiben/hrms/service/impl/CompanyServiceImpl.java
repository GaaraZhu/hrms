package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.CompanyDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Company;
import com.jisiben.hrms.service.CompanyService;
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
public class CompanyServiceImpl extends AbstractService<Company> implements CompanyService {

    @Autowired
    private CompanyDao dao;

    @Override
    protected Dao<Company, Long> getDao() {
        return dao;
    }

    @Override
    public Page<Company> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String name = criteria.get("name").map(Object::toString).orElse(null);
        String city = criteria.get("city").map(Object::toString).orElse(null);
        return dao.findByNameAndCity(name, city, new PageRequest(currentPage-1, pageSize));
    }

    public CompanyDao getBranchDao() {
        return dao;
    }

    public CompanyServiceImpl setBranchDao(CompanyDao dao) {
        this.dao = dao;
        return this;
    }
}
