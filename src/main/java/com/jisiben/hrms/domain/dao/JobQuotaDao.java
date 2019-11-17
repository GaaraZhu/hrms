package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobQuota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface JobQuotaDao extends Dao<JobQuota, Long> {
    @Query("FROM JobQuota jq WHERE (:company is null or jq.job.company = :company) and (:city is null or jq.job.city = :city)"
            + "and (:jobName is null or jq.job.name like CONCAT('%',:jobName,'%')) and (:month is null or jq.month = :month)")
    Page<JobQuota> findJobQuotas(
            @Param("company")String company,
            @Param("city")String city,
            @Param("jobName")String jobName,
            @Param("month")String month,
            Pageable pageable);
}
