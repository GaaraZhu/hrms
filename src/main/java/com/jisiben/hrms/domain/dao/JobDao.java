package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobDao extends Dao<Job, Long> {
    @Query("FROM Job j WHERE (:company is null or j.company.name = :company) and (:city is null or j.company.city = :city) "
            + " and (:name is null or j.name = :name) and (:active is null or j.active = :active)")
    Page<Job> findByCompanyAndCityAndNameAndActive(
            @Param("company")String company,
            @Param("city")String city,
            @Param("name")String name,
            @Param("active")Boolean active,
            Pageable pageable);
}
