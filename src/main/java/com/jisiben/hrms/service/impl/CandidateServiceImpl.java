package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.CandidateDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.service.CandidateService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Candidate> search(String name, String phone, String city, Pageable pageable) {
        return candidateDao.findByNameAndPhoneAndCity(name, phone, city, pageable);
    }
}
