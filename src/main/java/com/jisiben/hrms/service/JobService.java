package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.service.common.Service;

import java.util.Date;
import java.util.List;

public interface JobService extends Service<Job> {
    List<Pair> findTotalQuotaByCompany(Date fromTime, Date toTime);
}
