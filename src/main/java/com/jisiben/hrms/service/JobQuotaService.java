package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.JobQuota;
import com.jisiben.hrms.service.common.Service;
import org.springframework.data.repository.query.Param;

public interface JobQuotaService extends Service<JobQuota> {
    Long countJobQuota(@Param("jobId")Long jobId, @Param("month")String month);
}
