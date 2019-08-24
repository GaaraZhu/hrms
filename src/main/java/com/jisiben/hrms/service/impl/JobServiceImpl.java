package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.JobDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.service.JobService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends AbstractService<Job> implements JobService {
    @Autowired
    private JobDao jobDao;

    @Override
    public Page<Job> search(String company, String city, String name, Boolean active, Pageable pageable) {
        return jobDao.findByCompanyAndCityAndNameAndActive(company, city, name, active, pageable);
    }

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
}
