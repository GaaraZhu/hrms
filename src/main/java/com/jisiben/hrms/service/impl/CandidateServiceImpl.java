package com.jisiben.hrms.service.impl;

import java.util.Map;
import java.util.Optional;

import com.jisiben.hrms.domain.dao.CandidateDao;
import com.jisiben.hrms.domain.dao.UserDao;
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
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateServiceImpl extends AbstractService<Candidate> implements CandidateService {
    @Autowired
    private CandidateDao candidateDao;

    @Autowired
    private UserDao userDao;

    @Override
    protected Dao<Candidate, Long> getDao() {
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

    @Override
    public void migrateCandidates(Long originalUserId, Long targetUserId) {
        User target = userDao.findOne(targetUserId);
        User original = userDao.findOne(originalUserId);
        candidateDao.migrateCandidates(original.getAccount(), target.getAccount());
    }
}
