package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobQuota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface JobQuotaDao extends Dao<JobQuota, Long> {
    @Query("FROM JobQuota jq WHERE (:company is null or jq.job.company = :company) and (:city is null or jq.job.city = :city) and (:district is null or jq.job.district = :district)"
            + " and (:jobName is null or jq.job.name like CONCAT('%',:jobName,'%')) and (:month is null or jq.month = :month)")
    Page<JobQuota> findJobQuotas(
            @Param("company")String company,
            @Param("city")String city,
            @Param("district")String district,
            @Param("jobName")String jobName,
            @Param("month")String month,
            Pageable pageable);

    @Query("SELECT COUNT(jq) FROM JobQuota jq WHERE jq.job.id = :jobId and jq.month = :month")
    Long countByJobIdAndMonth(@Param("jobId")Long jobId, @Param("month")String month);

}
