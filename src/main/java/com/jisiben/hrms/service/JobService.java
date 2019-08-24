package com.jisiben.hrms.service;

import com.jisiben.hrms.domain.entity.Job;
import com.jisiben.hrms.service.common.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService extends Service<Job> {
    Page<Job> search(String company, String city, String name, Boolean active, Pageable pageable);
}
