package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.ApplicationReport;
import com.jisiben.hrms.service.common.Service;

public interface ApplicationReportService extends Service<ApplicationReport> {
    void generateApplicationWeeklyReport();

    void generateApplicationMonthlyReport();
}
