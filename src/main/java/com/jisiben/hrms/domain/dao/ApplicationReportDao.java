package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.ApplicationReport;
import com.jisiben.hrms.domain.entity.common.ApplicationReportType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ApplicationReportDao extends Dao<ApplicationReport, Long> {
    @Query("FROM ApplicationReport r WHERE (:fromDate is null or r.start > :fromDate) and (:toDate is null or r.end < :toDate)"
            + " and (:name is null or r.user.name like CONCAT('%',:name,'%')) and (:type is null or r.type = :type)")
    Page<ApplicationReport> findJobApplicationReports(
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate,
            @Param("name") String name,
            @Param("type") ApplicationReportType type,
            Pageable pageable);
}
