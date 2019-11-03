package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.JobDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.service.JobService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class JobServiceImpl extends AbstractService<Job> implements JobService {
    @Autowired
    private JobDao jobDao;

    @Override
    public Dao<Job, Long> getDao() {
        return jobDao;
    }

    public JobDao getJobDao() {
        return jobDao;
    }

    public void setJobDao(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public Page<Job> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String company = criteria.get("company").map(Object::toString).orElse(null);
        String city = criteria.get("city").map(Object::toString).orElse(null);
        String district = criteria.get("district").map(Object::toString).orElse(null);
        String name = criteria.get("name").map(Object::toString).orElse(null);
        Boolean active = criteria.get("active").map(Boolean.class::cast).orElse(null);
        return jobDao.findByCompanyAndCityAndNameAndActive(company, city, district, name, active, new PageRequest(currentPage-1, pageSize));
    }

}
