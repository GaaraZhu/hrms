package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobQuota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobQuotaDao extends Dao<JobQuota, Long> {
    @Query("FROM JobQuota jq WHERE (:company is null or jq.job.company.name like CONCAT('%',:company,'%')) and (:city is null or jq.job.company.city = :city) "
            + " and (:jobName is null or jq.job.name like CONCAT('%',:jobName,'%')) and (:month is null or jq.month = :month) ORDER BY jq.month DESC")
    Page<JobQuota> findJobQuotas(
            @Param("company")String company,
            @Param("city")String city,
            @Param("jobName")String jobName,
            @Param("month")String month,
            Pageable pageable);

    @Query("SELECT COUNT(jq) FROM JobQuota jq WHERE jq.job.id = :jobId and jq.month = :month")
    Long countByJobIdAndMonth(@Param("jobId")Long jobId, @Param("month")String month);

    //TODO: FIXME
//    @Query("SELECT new com.jisiben.hrms.domain.dao.bean.Pair('abc', jq.quota) FROM JobQuota jq where jq.month = :month and (:company is null or jq.job.company = :company)")
//    List<Pair> getMonthlyQuota(@Param("company")String company, @Param("month")String month);
}
