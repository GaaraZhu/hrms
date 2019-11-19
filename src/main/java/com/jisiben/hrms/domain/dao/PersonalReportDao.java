package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.PersonalReport;
import com.jisiben.hrms.domain.entity.common.PersonalReportType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PersonalReportDao extends Dao<PersonalReport, Long> {
    @Query("FROM PersonalReport r WHERE (:fromDate is null or r.start > :fromDate) and (:toDate is null or r.end < :toDate)"
            + " and (:name is null or r.user.name like CONCAT('%',:name,'%')) and (:type is null or r.type = :type)")
    Page<PersonalReport> findJobApplicationReports(
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate,
            @Param("name") String name,
            @Param("type") PersonalReportType type,
            Pageable pageable);
}
