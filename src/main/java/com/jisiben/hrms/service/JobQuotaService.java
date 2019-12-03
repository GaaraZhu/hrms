package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.entity.JobQuota;
import com.jisiben.hrms.service.common.Service;

import java.util.List;

public interface JobQuotaService extends Service<JobQuota> {
    Long countJobQuota(Long jobId, String month, Long branchId);
    List<Pair> getMonthlyQuota(String company, String month);
}
