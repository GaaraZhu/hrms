package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.service.common.Service;

public interface JobApplicationService extends Service<JobApplication> {
    Long findActiveJobApplicationCount(String candidateIdNumber, Long jobId);

    void migrateJobApplications(Long originalUserId, Long targetUserId);
}
