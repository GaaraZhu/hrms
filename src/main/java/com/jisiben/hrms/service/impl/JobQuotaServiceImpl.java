package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.JobQuotaDao;
import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobQuota;
import com.jisiben.hrms.service.JobQuotaService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class JobQuotaServiceImpl extends AbstractService<JobQuota> implements JobQuotaService {
    @Autowired
    private JobQuotaDao JobQuotaDao;

    @Autowired
    private UserDao userDao;

    @Override
    protected Dao<JobQuota, Long> getDao() {
        return JobQuotaDao;
    }

    @Override
    public Page<JobQuota> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        return null;
    }
}
