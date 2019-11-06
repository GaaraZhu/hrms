package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.service.common.Service;

public interface CandidateService extends Service<Candidate> {
    Candidate findByIdNumber(String idNumber);
    void migrateCandidates(Long originalUserId, Long targetUserId);
}
