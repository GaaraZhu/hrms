package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.JobQuotaDao;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobQuota;
import com.jisiben.hrms.service.JobQuotaService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class JobQuotaServiceImpl extends AbstractService<JobQuota> implements JobQuotaService {
    @Autowired
    private JobQuotaDao jobQuotaDao;

    @Override
    protected Dao<JobQuota, Long> getDao() {
        return jobQuotaDao;
    }

    @Override
    public Page<JobQuota> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String company = criteria.get("company").map(Object::toString).orElse(null);
        String city = criteria.get("city").map(Object::toString).orElse(null);
        String jobName = criteria.get("jobName").map(Object::toString).orElse(null);
        String month = criteria.get("month").map(Object::toString).orElse(null);
        return jobQuotaDao.findJobQuotas(company, city, jobName, month, new PageRequest(currentPage - 1, pageSize));
    }

    @Override
    public Long countJobQuota(Long jobId, String month, Long branchId) {
        return jobQuotaDao.countByJobIdAndMonth(jobId, month, branchId);
    }

    @Override
    public List<Pair> getMonthlyQuota(String company, String month) {
        return jobQuotaDao.getMonthlyQuota(company, month);
    }
}
