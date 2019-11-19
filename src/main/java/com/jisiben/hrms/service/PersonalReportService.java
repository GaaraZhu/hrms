package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.PersonalReport;
import com.jisiben.hrms.service.common.Service;

public interface PersonalReportService extends Service<PersonalReport> {
    void generateApplicationWeeklyReport();

    void generateApplicationMonthlyReport();
}
