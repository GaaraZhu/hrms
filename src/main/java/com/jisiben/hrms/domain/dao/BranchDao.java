package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BranchDao extends Dao<Branch, Long> {
    @Query("FROM Branch c WHERE (:company is null or c.company.name = :company) and (:branch is null"
            + " or c.name = :branch)")
    Page<Branch> findByManagerAndName(@Param("company")String company, @Param("branch")String branch, Pageable pageable);
}
