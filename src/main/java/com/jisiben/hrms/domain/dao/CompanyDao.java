package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyDao extends Dao<Company, Long> {
    @Query("FROM Company c WHERE (:name is null or c.name like CONCAT('%',:name,'%')) and (:city is null"
            + " or c.city = :city)")
    Page<Company> findByNameAndCity(@Param("name")String name, @Param("city")String city, Pageable pageable);
}
