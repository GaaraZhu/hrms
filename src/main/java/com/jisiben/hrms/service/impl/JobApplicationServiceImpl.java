package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.JobApplicationDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.service.JobApplicationService;
import com.jisiben.hrms.service.common.impl.AbstractService;
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
        Integer jobId = criteria.get("jobId").map(Integer.class::cast).orElse(null);
        Boolean hasReferee = criteria.get("hasReferee").map(Boolean.class::cast).orElse(null);
        String phone = criteria.get("phone").map(Object::toString).orElse(null);
        String name = criteria.get("name").map(Object::toString).orElse(null);
        String status = criteria.get("status").map(Object::toString).orElse(null);
        Date fromTime = criteria.get("fromTime").map(Date.class::cast).orElse(null);
        Date toTime = criteria.get("toTime").map(Date.class::cast).orElse(null);

        return dao.findJobApplications(company, city, jobId, hasReferee, phone, name, status, fromTime, toTime, new PageRequest(currentPage - 1, pageSize));
    }
}