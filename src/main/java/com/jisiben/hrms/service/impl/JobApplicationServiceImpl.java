package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.JobApplicationDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import com.jisiben.hrms.service.JobApplicationService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class JobApplicationServiceImpl extends AbstractService<JobApplication> implements JobApplicationService {
    @Autowired
    private JobApplicationDao dao;

    @Override
    public Dao<JobApplication, Long> getDao() {
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

        return dao.findJobApplications(company, city, jobName, hasReferee, candidate, referee, status, fromTime, toTime, new PageRequest(currentPage - 1, pageSize));
    }
}