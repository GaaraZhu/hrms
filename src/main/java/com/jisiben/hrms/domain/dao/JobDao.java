package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface JobDao extends Dao<Job, Long> {
    @Query("FROM Job j WHERE (:company is null or j.company = :company) and (:city is null or j.city = :city) and (:district is null or j.district like CONCAT('%',:district,'%')) "
            + " and (:name is null or j.name = :name) and (:active is null or j.active = :active)")
    Page<Job> findByCompanyAndCityAndNameAndActive(
            @Param("company")String company,
            @Param("city")String city,
            @Param("district")String district,
            @Param("name")String name,
            @Param("active")Boolean active,
            Pageable pageable);

        @Query("SELECT new com.jisiben.hrms.domain.dao.bean.Pair(j.company, SUM(j.quota)) FROM Job j WHERE (:fromTime is null or j.createdTime >= :fromTime) and (:toTime is null or j.createdTime <= :toTime) GROUP BY j.company")
        List<Pair> findTotalQuotaByCompany(@Param("fromTime") Date fromTime, @Param("toTime")Date toTime);
}
