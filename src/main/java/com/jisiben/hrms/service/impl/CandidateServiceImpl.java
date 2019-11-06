package com.jisiben.hrms.service.impl;

import java.util.Map;
import java.util.Optional;

import com.jisiben.hrms.domain.dao.CandidateDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.service.CandidateService;
import com.jisiben.hrms.service.common.impl.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl extends AbstractService<Candidate> implements CandidateService {
    @Autowired
    private CandidateDao candidateDao;

    @Override
    public Dao<Candidate, Long> getDao() {
        return candidateDao;
    }

    @Override
    public Page<Candidate> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String name = criteria.get("name").map(Object::toString).orElse(null);
        String phone = criteria.get("phone").map(Object::toString).orElse(null);
        String createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
        return candidateDao.findByNameAndPhone(name, phone, createdBy, new PageRequest(currentPage-1, pageSize));
    }

    @Override
    public Candidate findByIdNumber(String idNumber) {
        return candidateDao.findByIdNumber(idNumber);
    }
}
