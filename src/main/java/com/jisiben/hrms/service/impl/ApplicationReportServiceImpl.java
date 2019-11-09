package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.ApplicationReportDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.ApplicationReport;
import com.jisiben.hrms.domain.entity.common.ApplicationReportType;
import com.jisiben.hrms.service.ApplicationReportService;
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
public class ApplicationReportServiceImpl extends AbstractService<ApplicationReport> implements ApplicationReportService {
    @Autowired
    private ApplicationReportDao dao;

    @Override
    public Dao<ApplicationReport, Long> getDao() {
        return dao;
    }

    @Override
    public Page<ApplicationReport> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        Date fromDate = criteria.get("fromDate").map(Date.class::cast).orElse(null);
        Date toDate = criteria.get("toDate").map(Date.class::cast).orElse(null);
        String name = criteria.get("name").map(Object::toString).orElse(null);
        String typeString = criteria.get("type").map(Object::toString).orElse(null);
        ApplicationReportType type = StringUtils.isEmpty(typeString)?null:ApplicationReportType.valueOf(typeString);

        return dao.findJobApplicationReports(fromDate, toDate, name, type, new PageRequest(currentPage - 1, pageSize));
    }
}
