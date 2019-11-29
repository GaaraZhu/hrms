package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.JobApplicationDao;
import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import com.jisiben.hrms.service.JobApplicationService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class JobApplicationServiceImpl extends AbstractService<JobApplication> implements JobApplicationService {
    @Autowired
    private JobApplicationDao dao;

    @Autowired
    private UserDao userDao;

    @Override
    protected Dao<JobApplication, Long> getDao() {
        return dao;
    }

    public JobApplicationDao getJobApplicationDao() {
        return dao;
    }

    public void setJobApplicationDao(JobApplicationDao dao) {
        this.dao = dao;
    }

    @Override
    public Page<JobApplication> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String company = criteria.get("company").map(Object::toString).orElse(null);
        String city = criteria.get("city").map(Object::toString).orElse(null);
        String jobName = criteria.get("jobName").map(Object::toString).orElse(null);
        Boolean hasReferee = criteria.get("hasReferee").map(Boolean.class::cast).orElse(null);
        String candidate = criteria.get("candidate").map(Object::toString).orElse(null);
        String referee = criteria.get("referee").map(Object::toString).orElse(null);
        String statusString = criteria.get("status").map(Object::toString).orElse(null);
        JobApplicationStatus status = StringUtils.isEmpty(statusString)?null:JobApplicationStatus.valueOf(statusString);
        Date fromTime = criteria.get("fromTime").map(Date.class::cast).orElse(null);
        Date toTime = criteria.get("toTime").map(Date.class::cast).orElse(null);
        String createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.findJobApplications(company, city, jobName, hasReferee, candidate, referee, status, fromTime, toTime, createdBy, new PageRequest(currentPage - 1, pageSize));
    }

    @Override
    public Long findActiveJobApplicationCount(String candidateIdNumber, Long jobId) {
        return dao.countByCandidateIdNumber(candidateIdNumber, jobId);
    }

    @Override
    public void migrateJobApplications(Long originalUserId, Long targetUserId) {
        User target = userDao.findOne(targetUserId);
        User original = userDao.findOne(originalUserId);
        dao.migrateJobApplications(original.getAccount(), target.getAccount());
    }

    @Override
    public List<Pair> findSuccessApplicantsByCompany(Date fromTime, Date toTime) {
        return dao.findSuccessApplicantsByCompany(fromTime, toTime);
    }

    @Override
    public List<Pair> findOnboardCountByCompany(String company, String month) {
        return dao.findOnboardCountByCompany(company, month);
    }

    @Override
    public List<Pair> findResignCountByCompany(String company, String month) {
        return dao.findResignCountByCompany(company, month);
    }

    @Override
    public Object[][] countOnboards(String company, String jobName, long branchId, int year, int month) {
        return dao.countOnboards(company, jobName, branchId, year, month);
    }

    @Override
    public Object[][] countResigns(String company, String jobName, long branchId, int year, int month) {
        return dao.countResigns(company, jobName, branchId, year, month);
    }
}