package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface JobApplicationDao extends Dao<JobApplication, Long> {
    @Query("FROM JobApplication ja WHERE (:company is null or ja.job.company = :company) and (:city is null or ja.job.city = :city)"
            + "and (:jobId is null or ja.job.id = :jobId) and (:hasReferee is null or (:hasReferee=true and ja.referee is not null) or (:hasReferee=false and ja.referee is null))"
            + "and (:phone is null or ja.candidate.phone = :phone) and (:name is null or ja.candidate.name = :name) and (:status is null or ja.status = :status)"
            + "and (:fromTime is null or ja.createdTime >= :fromTime) and (:toTime is null or ja.createdTime <= :toTime)")
    Page<JobApplication> findJobApplications(
            @Param("company")String company,
            @Param("city")String city,
            @Param("jobId")Integer jobId,
            @Param("hasReferee")Boolean hasReferee,
            @Param("phone")String phone,
            @Param("name")String name,
            @Param("status")String status,
            @Param("fromTime") Date fromTime,
            @Param("toTime")Date toTime,
            Pageable pageable);
}
