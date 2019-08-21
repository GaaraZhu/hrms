package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.Candidate;
import com.jisiben.hrms.service.common.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidateService extends Service<Candidate> {
    Page<Candidate> search(String name, String phone, String city, Pageable pageable);
}
