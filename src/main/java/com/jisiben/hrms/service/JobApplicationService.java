package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.service.common.Service;

import java.util.Date;
import java.util.List;

public interface JobApplicationService extends Service<JobApplication> {
    Long findActiveJobApplicationCount(String candidateIdNumber, Long jobId);

    void migrateJobApplications(Long originalUserId, Long targetUserId);

    List<Pair> findSuccessApplicantsByCompany(Date fromTime, Date toTime);

    List<Pair> findOnboardCountByCompany(String company, String month);

    List<Pair> findResignCountByCompany(String company, String month);
}
